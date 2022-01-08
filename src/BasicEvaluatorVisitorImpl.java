import java.util.ArrayList;
import java.util.List;

public class BasicEvaluatorVisitorImpl  extends BasicEvaluatorBaseVisitor<Value> {
    private final SymbolTable symbolTable;
    private final FunctionTable functionTable;

    public BasicEvaluatorVisitorImpl(SymbolTable symbolTable, FunctionTable functionTable) {
        this.symbolTable = symbolTable;
        this.functionTable = functionTable;
    }

    @Override
    public Value visitExpressionInput(BasicEvaluatorParser.ExpressionInputContext ctx) {
        Value value = visit(ctx.expression());
        if (value != null && value.isDefined())
            System.out.println(value.numberValue());

        return value;
    }

    @Override
    public Value visitFunDefInput(BasicEvaluatorParser.FunDefInputContext ctx) {
        Value functionName = visit(ctx.fundef());
        if (functionName != null && functionName.isDefined())
            System.out.println(functionName.stringValue());

        return functionName;
    }

    @Override
    public Value visitFundef(BasicEvaluatorParser.FundefContext ctx) {
        String functionName = ctx.function().getText();
        FunctionDefinition function = new FunctionDefinition();
        List<BasicEvaluatorParser.VariableContext> arguments = ctx.arglist().variable();
        for (BasicEvaluatorParser.VariableContext argument :arguments) {
            function.argumentList.add(argument.getText());
        }
        function.expression = ctx.expression();
        functionTable.set(functionName, function);

        return new Value(functionName);
    }

    @Override
    public Value visitArglist(BasicEvaluatorParser.ArglistContext ctx) {
        return super.visitArglist(ctx);
    }

    @Override
    public Value visitValueExpr(BasicEvaluatorParser.ValueExprContext ctx) {
        return visit(ctx.value());
    }

    @Override
    public Value visitVariableExpr(BasicEvaluatorParser.VariableExprContext ctx) {
        String variableName = ctx.variable().getText();
        Value value = symbolTable.getSymbol(variableName);
        if (value != null) {
            return value;
        } else {
            System.out.println("Undefined variable: " + variableName);
            return new Value(null);
        }
    }

    @Override
    public Value visitIfExpr(BasicEvaluatorParser.IfExprContext ctx) {
        Value comparison = visit(ctx.expression(0));
        if (comparison.isFalse())
            return visit(ctx.expression(2));
        else
            return visit(ctx.expression(1));
    }

    @Override
    public Value visitWhileExpr(BasicEvaluatorParser.WhileExprContext ctx) {
        Value condition = visit(ctx.expression(0));
        while (condition.isTrue()) {
            visit(ctx.expression(1));
            condition = visit(ctx.expression(0));
        }
        return condition;
    }

    @Override
    public Value visitSetExpr(BasicEvaluatorParser.SetExprContext ctx) {
        String variable = ctx.variable().getText();
        Value value = visit(ctx.expression());

        symbolTable.setSymbol(variable, value);

        return value;
    }

    @Override
    public Value visitBeginExpr(BasicEvaluatorParser.BeginExprContext ctx) {
        Value currentValue = visit(ctx.expression(0));
        int i = 1;

        while (true) {
            if (ctx.expression(i) != null)
                currentValue = visit(ctx.expression(i++));
            else
                break;
        }
        return currentValue;
    }

    @Override
    public Value visitFunctionExpr(BasicEvaluatorParser.FunctionExprContext ctx) {
        String functionName = ctx.function().getText();
        FunctionDefinition function = functionTable.get(functionName);
        if (function != null) {
            // Step #1: check actual arg count with formal arg count
            int argCount = function.argumentList.size();
            if (argCount != ctx.expression().size()) {
                System.out.println("Wrong number of arguments to: " + functionName);
                return new Value(null);
            }

            // Step #2: get values of actual arguments and add to local
            //          environment using formal argument names
            Value[] actualArgs = new Value[argCount];
            int i = 0;
            while (ctx.expression(i) != null) {
                Value argValue = visit(ctx.expression(i));
                actualArgs[i] = argValue;
                i++;
            }

            // Step #3: create new local environment
            symbolTable.addEnvironment();

            // Step #4: add actual args to formal args in local environment of function
            for (int j = 0; j < argCount; j++) {
                symbolTable.setSymbol(function.argumentList.get(j), actualArgs[j]);
            }

            // Step #5: execute function expression
            Value functionValue = visit(function.expression);

            // Step #6: remove local environment
            symbolTable.removeEnvironment();

            return functionValue;
        } else {
            System.out.println("Undefined function: " + functionName);
            return new Value(null);
        }
    }

    @Override
    public Value visitOptrExpr(BasicEvaluatorParser.OptrExprContext ctx) {
        Value left = visit(ctx.expression(0));
        Value right = visit(ctx.expression(1));

        switch (ctx.op.getType()) {
            case BasicEvaluatorParser.ADD:
                assert right != null;
                return new Value(left.numberValue() + right.numberValue());
            case BasicEvaluatorParser.SUB:
                assert right != null;
                return new Value(left.numberValue() - right.numberValue());
            case BasicEvaluatorParser.MUL:
                assert right != null;
                return new Value(left.numberValue() * right.numberValue());
            case BasicEvaluatorParser.DIV:
                assert right != null;
                return new Value(left.numberValue() / right.numberValue());
            case BasicEvaluatorParser.EQ:
                assert right != null;
                return left.numberValue() == right.numberValue() ? Value.TRUE : Value.FALSE;
            case BasicEvaluatorParser.LT:
                assert right != null;
                return left.numberValue() < right.numberValue() ? Value.TRUE : Value.FALSE;
            case BasicEvaluatorParser.GT:
                assert right != null;
                return left.numberValue() > right.numberValue() ? Value.TRUE : Value.FALSE;
            default:
                return new Value(null);
        }
    }

    @Override
    public Value visitPrintExpr(BasicEvaluatorParser.PrintExprContext ctx) {
        Value value = visit(ctx.expression());
        System.out.println(value.numberValue());
        return value;
    }

    @Override
    public Value visitValue(BasicEvaluatorParser.ValueContext ctx) {
        return new Value(Long.parseLong(ctx.getText()));
    }
}
