package BasicEvaluatorInterpreter;

import BasicEvaluatorParser.BasicEvaluatorBaseVisitor;
import BasicEvaluatorParser.BasicEvaluatorParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicEvaluatorVisitorImpl  extends BasicEvaluatorBaseVisitor<EvaluatorInput> {
    private final Memory memory;
    private final Set<String> keywords = new HashSet<>();

    public BasicEvaluatorVisitorImpl(Memory memory) {
        this.memory = memory;
        installKeywords();
    }
    private void installKeywords() {
        keywords.add("define");
        keywords.add("if");
        keywords.add("while");
        keywords.add("set");
        keywords.add("begin");
        keywords.add("+");
        keywords.add("-");
        keywords.add("*");
        keywords.add("/");
        keywords.add("=");
        keywords.add("<");
        keywords.add(">");
        keywords.add("print");
    }

    @Override
    public FunctionDef visitFunDef(BasicEvaluatorParser.FunDefContext ctx) {
        FunctionDefinition function = new FunctionDefinition();

        String functionName = ctx.function().getText();
        if (keywords.contains(functionName)) {
            throw new InterpreterException("Invalid function name: " + functionName, null);
        }
        function.name = functionName;

        List<BasicEvaluatorParser.VariableContext> arguments = ctx.argList().variable();
        for (BasicEvaluatorParser.VariableContext argument :arguments) {
            function.argumentList.add(argument.getText());
        }

        function.expression = ctx.expression();

        memory.setFunction(functionName, function);

        return new FunctionDef(functionName);
    }

    @Override
    public ExprResult visitValueExpr(BasicEvaluatorParser.ValueExprContext ctx) {
        try {
            Integer value = Integer.parseInt(ctx.value().getText());
            return new ExprResult(new Value(value));
        } catch (NumberFormatException err) {
            throw new InterpreterException("Value not an Integer", err);
        }
    }

    @Override
    public ExprResult visitVariableExpr(BasicEvaluatorParser.VariableExprContext ctx) {
        Variable variable = (Variable)visit(ctx.variable());
        String variableName = variable.getVariableName();
        Value value = memory.getSymbol(variableName);
        if (value != null) {
            return new ExprResult(value);
        } else {
            throw new InterpreterException("Undefined variable: " + variableName, null);
        }
    }

    @Override
    public ExprResult visitIfExpr(BasicEvaluatorParser.IfExprContext ctx) {
        ExprResult comparison = (ExprResult) visit(ctx.expression(0));
        if (comparison == null) throw new InterpreterException("if condition invalid", null);

        if (comparison.getResult().isFalse()) {
            ExprResult falseResult = (ExprResult) visit(ctx.expression(2));
            if (falseResult == null) throw new InterpreterException("if false clause invalid", null);
            return falseResult;
        }
        else {
            ExprResult trueResult = (ExprResult) visit(ctx.expression(1));
            if (trueResult == null) throw new InterpreterException("if true clause invalid", null);
            return trueResult;
        }
    }

    @Override
    public ExprResult visitWhileExpr(BasicEvaluatorParser.WhileExprContext ctx) {
        ExprResult condition = (ExprResult) visit(ctx.expression(0));
        if (condition == null) throw new InterpreterException("while condition invalid", null);

        while (condition.getResult().isTrue()) {
            ExprResult result = (ExprResult) visit(ctx.expression(1));
            if (result == null) throw new InterpreterException("while loop invalid", null);

            condition = (ExprResult) visit(ctx.expression(0));
        }
        return condition;
    }

    @Override
    public ExprResult visitSetExpr(BasicEvaluatorParser.SetExprContext ctx) {
        Variable variable = (Variable) visit(ctx.variable());
        if (variable == null) throw new InterpreterException("set variable invalid", null);
        ExprResult value = (ExprResult) visit(ctx.expression());
        if (value == null) throw new InterpreterException("set expression invalid", null);

        memory.setSymbol(variable.getVariableName(), value.getResult());

        return value;
    }

    @Override
    public ExprResult visitBeginExpr(BasicEvaluatorParser.BeginExprContext ctx) {
        if (ctx.expression(0) == null)
            throw new InterpreterException("begin requires at least one expression", null);

        ExprResult currentValue = (ExprResult) visit(ctx.expression(0));
        int i = 1;

        while (true) {
            if (ctx.expression(i) != null)
                currentValue = (ExprResult) visit(ctx.expression(i++));
            else
                break;
        }
        return currentValue;
    }

    @Override
    public ExprResult visitOperatorExpr(BasicEvaluatorParser.OperatorExprContext ctx) {
        Operation operation = (Operation) visit(ctx.operator());
        if (operation instanceof Operator operator) {
            return applyOperator(operator.getOperator(), ctx.expression());
        } else if (operation instanceof FunctionCall functionCall) {
            return applyFunctionCall(functionCall.getFunctionName(), ctx.expression());
        } else {
            return new ExprResult(new Value(null));
        }
    }

    @Override
    public Operation visitFunctionExpr(BasicEvaluatorParser.FunctionExprContext ctx) {
        String functionName = ctx.function().getText();
        return new FunctionCall(functionName);
    }

    @Override
    public Operation visitValueOpExpr(BasicEvaluatorParser.ValueOpExprContext ctx) {
        String operator = ctx.valueOp().getText();
        return new Operator(operator);
    }

    private ExprResult applyOperator(String operator,
                                     List<BasicEvaluatorParser.ExpressionContext> expressions) {
        // check if correct number of operands were parsed
        int numOperands = expressions.size();
        boolean valid;
        if (operator.equals("print")) {
            valid = numOperands == 1;
        } else {
            valid = numOperands == 2;
        }

        if (valid)
        {
            Integer op1Value = ((ExprResult) visit(expressions.get(0))).getResult().getValue();

            switch (operator) {
                case "+", "-", "*", "/", "=", "<", ">" -> {
                    Integer op2Value = ((ExprResult) visit(expressions.get(1))).getResult().getValue();
                    Integer result = switch (operator) {
                        case "+" -> op1Value + op2Value;
                        case "-" -> op1Value - op2Value;
                        case "*" -> op1Value * op2Value;
                        case "/" -> op1Value / op2Value;
                        case "=" -> op1Value.equals(op2Value) ? Value.TRUE.getValue() : Value.FALSE.getValue();
                        case "<" -> op1Value < op2Value ? Value.TRUE.getValue() : Value.FALSE.getValue();
                        case ">" -> op1Value > op2Value ? Value.TRUE.getValue() : Value.FALSE.getValue();
                        default -> null;
                    };
                    return new ExprResult(new Value(result));
                }

                case "print" -> {
                    System.out.println(op1Value);
                    return new ExprResult(new Value(op1Value));
                }
                default -> throw new InterpreterException("Invalid operator: " + operator, null);
            }
        } else {
            throw new InterpreterException("Wrong number of arguments to " + operator, null);
        }
    }

    private ExprResult applyFunctionCall(String functionName,
                                         List<BasicEvaluatorParser.ExpressionContext> expressions) {
        FunctionDefinition function = memory.getFunction(functionName);
        if (function != null) {
            // Step #1: check actual arg count with formal arg count
            int argCount = function.argumentList.size();
            if (argCount != expressions.size()) {
                throw new InterpreterException("Wrong number of arguments to: " + functionName, null);
            }

            // Step #2: get values of actual arguments
            Value[] actualArgs = new Value[argCount];
            for (int i = 0; i < argCount; i++) { // argCount == expressions.size()
                ExprResult argValue = (ExprResult) visit(expressions.get(i));
                if (argValue == null)
                    throw new InterpreterException("invalid actual argument for formal argument " +
                            function.argumentList.get(i) +
                            " in function " +
                            functionName, null);
                actualArgs[i] = argValue.getResult();
            }

            // Step #3: create new local environment
            memory.addLocalEnvironment();

            // Step #4: add actual args to formal args in local environment of function
            //          using the formal argument names
            for (int i = 0; i < argCount; i++) {
                memory.setLocalSymbol(function.argumentList.get(i), actualArgs[i]);
            }

            // Step #5: execute function expression
            ExprResult functionValue = (ExprResult) visit(function.expression);

            // Step #6: remove local environment
            memory.removeLocalEnvironment();

            return functionValue;
        } else {
            throw new InterpreterException("Undefined function: " + functionName, null);
        }
    }

    @Override
    public Variable visitVariable(BasicEvaluatorParser.VariableContext ctx) {
        String variableName = ctx.getText();
        if (ctx.exception != null) throw new InterpreterException("Invalid variable: " + variableName, null);
        return new Variable(variableName);
    }
}
