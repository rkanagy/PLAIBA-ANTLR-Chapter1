import java.util.List;
import java.util.Objects;

public class BasicEvaluatorVisitorImpl  extends BasicEvaluatorBaseVisitor<BasicEvaluatorInfo> {
    private final Memory memory;

    public BasicEvaluatorVisitorImpl(Memory memory) {
        this.memory = memory;
    }

    @Override
    public BasicEvaluatorInfo visitFunDef(BasicEvaluatorParser.FunDefContext ctx) {
        String functionName = ctx.function().getText();
        FunctionDefinition function = new FunctionDefinition();
        List<BasicEvaluatorParser.VariableContext> arguments = ctx.argList().variable();
        for (BasicEvaluatorParser.VariableContext argument :arguments) {
            function.argumentList.add(argument.getText());
        }
        function.expression = ctx.expression();
        memory.setFunction(functionName, function);

        return new BasicEvaluatorInfo(functionName);
    }

    @Override
    public BasicEvaluatorInfo visitValueExpr(BasicEvaluatorParser.ValueExprContext ctx) {
        return visit(ctx.value());
    }

    @Override
    public BasicEvaluatorInfo visitVariableExpr(BasicEvaluatorParser.VariableExprContext ctx) {
        String variableName = ctx.variable().getText();
        Value value = memory.getSymbol(variableName);
        if (value != null) {
            return new BasicEvaluatorInfo(value);
        } else {
            System.out.println("Undefined variable: " + variableName);

            return new BasicEvaluatorInfo(new Value(null));
        }
    }

    @Override
    public BasicEvaluatorInfo visitIfExpr(BasicEvaluatorParser.IfExprContext ctx) {
        BasicEvaluatorInfo comparison = visit(ctx.expression(0));
        if (comparison.getExpressionValue().isFalse())
            return visit(ctx.expression(2));
        else
            return visit(ctx.expression(1));
    }

    @Override
    public BasicEvaluatorInfo visitWhileExpr(BasicEvaluatorParser.WhileExprContext ctx) {
        BasicEvaluatorInfo condition = visit(ctx.expression(0));
        while (condition.getExpressionValue().isTrue()) {
            visit(ctx.expression(1));
            condition = visit(ctx.expression(0));
        }
        return condition;
    }

    @Override
    public BasicEvaluatorInfo visitSetExpr(BasicEvaluatorParser.SetExprContext ctx) {
        String variable = ctx.variable().getText();
        BasicEvaluatorInfo value = visit(ctx.expression());

        memory.setSymbol(variable, value.getExpressionValue());

        return value;
    }

    @Override
    public BasicEvaluatorInfo visitBeginExpr(BasicEvaluatorParser.BeginExprContext ctx) {
        BasicEvaluatorInfo currentValue = visit(ctx.expression(0));
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
    public BasicEvaluatorInfo visitFunctionExpr(BasicEvaluatorParser.FunctionExprContext ctx) {
        String functionName = ctx.function().getText();
        FunctionDefinition function = memory.getFunction(functionName);
        if (function != null) {
            // Step #1: check actual arg count with formal arg count
            int argCount = function.argumentList.size();
            if (argCount != ctx.expression().size()) {
                System.out.println("Wrong number of arguments to: " + functionName);
                return new BasicEvaluatorInfo(new Value(null));
            }

            // Step #2: get values of actual arguments and add to local
            //          environment using formal argument names
            Value[] actualArgs = new Value[argCount];
            int i = 0;
            while (ctx.expression(i) != null) {
                BasicEvaluatorInfo argValue = visit(ctx.expression(i));
                actualArgs[i] = argValue.getExpressionValue();
                i++;
            }

            // Step #3: create new local environment
            memory.addLocalEnvironment();

            // Step #4: add actual args to formal args in local environment of function
            for (int j = 0; j < argCount; j++) {
                memory.setLocalSymbol(function.argumentList.get(j), actualArgs[j]);
            }

            // Step #5: execute function expression
            BasicEvaluatorInfo functionValue = visit(function.expression);

            // Step #6: remove local environment
            memory.removeLocalEnvironment();

            return functionValue;
        } else {
            System.out.println("Undefined function: " + functionName);
            return new BasicEvaluatorInfo(new Value(null));
        }
    }

    @Override
    public BasicEvaluatorInfo visitOperatorExpr(BasicEvaluatorParser.OperatorExprContext ctx) {
        BasicEvaluatorInfo left = visit(ctx.expression(0));
        BasicEvaluatorInfo right = visit(ctx.expression(1));
        Value leftValue = left.getExpressionValue();
        Value rightValue = right.getExpressionValue();

        return switch (ctx.op.getType()) {
            case BasicEvaluatorParser.ADD -> new BasicEvaluatorInfo(new Value(
                    leftValue.getValue() + rightValue.getValue()));
            case BasicEvaluatorParser.SUB -> new BasicEvaluatorInfo(new Value(
                    leftValue.getValue() - rightValue.getValue()));
            case BasicEvaluatorParser.MUL -> new BasicEvaluatorInfo(new Value(
                    leftValue.getValue() * rightValue.getValue()));
            case BasicEvaluatorParser.DIV -> new BasicEvaluatorInfo(new Value(
                    leftValue.getValue() / rightValue.getValue()));
            case BasicEvaluatorParser.EQ -> new BasicEvaluatorInfo(
                    Objects.equals(leftValue.getValue(), rightValue.getValue())
                        ? Value.TRUE
                        : Value.FALSE);
            case BasicEvaluatorParser.LT -> new BasicEvaluatorInfo(
                    leftValue.getValue() < rightValue.getValue()
                        ? Value.TRUE
                        : Value.FALSE);
            case BasicEvaluatorParser.GT -> new BasicEvaluatorInfo(
                    leftValue.getValue() > rightValue.getValue()
                        ? Value.TRUE
                        : Value.FALSE);
            default -> new BasicEvaluatorInfo(new Value(null));
        };
    }

    @Override
    public BasicEvaluatorInfo visitPrintExpr(BasicEvaluatorParser.PrintExprContext ctx) {
        BasicEvaluatorInfo value = visit(ctx.expression());
        System.out.println(value.getExpressionValue().getValue());
        return value;
    }

    @Override
    public BasicEvaluatorInfo visitValue(BasicEvaluatorParser.ValueContext ctx) {
        return new BasicEvaluatorInfo(new Value(Integer.parseInt(ctx.getText())));
    }
}
