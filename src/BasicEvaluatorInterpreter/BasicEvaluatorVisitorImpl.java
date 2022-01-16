package BasicEvaluatorInterpreter;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import BasicEvaluatorParser.*;

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
            System.out.println("Invalid function name: " + functionName);
            return null;
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
        String strValue = ctx.value().getText();
        return new ExprResult(new Value(Integer.parseInt(strValue)));
    }

    @Override
    public ExprResult visitVariableExpr(BasicEvaluatorParser.VariableExprContext ctx) {
        String variableName = ctx.variable().getText();
        Value value = memory.getSymbol(variableName);
        if (value != null) {
            return new ExprResult(value);
        } else {
            System.out.println("Undefined variable: " + variableName);

            return new ExprResult(new Value(null));
        }
    }

    @Override
    public ExprResult visitIfExpr(BasicEvaluatorParser.IfExprContext ctx) {
        ExprResult comparison = (ExprResult) visit(ctx.expression(0));
        if (comparison.getResult().isFalse())
            return (ExprResult) visit(ctx.expression(2));
        else
            return (ExprResult) visit(ctx.expression(1));
    }

    @Override
    public ExprResult visitWhileExpr(BasicEvaluatorParser.WhileExprContext ctx) {
        ExprResult condition = (ExprResult) visit(ctx.expression(0));
        while (condition.getResult().isTrue()) {
            visit(ctx.expression(1));
            condition = (ExprResult) visit(ctx.expression(0));
        }
        return condition;
    }

    @Override
    public ExprResult visitSetExpr(BasicEvaluatorParser.SetExprContext ctx) {
        String variable = ctx.variable().getText();
        ExprResult value = (ExprResult) visit(ctx.expression());

        memory.setSymbol(variable, value.getResult());

        return value;
    }

    @Override
    public ExprResult visitBeginExpr(BasicEvaluatorParser.BeginExprContext ctx) {
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
    public Operation visitFunctionExpr(BasicEvaluatorParser.FunctionExprContext ctx) {
        String functionName = ctx.function().getText();
        return new Operation(functionName);
    }

    @Override
    public Operation visitValueOpExpr(BasicEvaluatorParser.ValueOpExprContext ctx) {
        int valueOp = ctx.valueOp().op.getType();
        return new Operation(valueOp);
    }

    @Override
    public ExprResult visitOperatorExpr(BasicEvaluatorParser.OperatorExprContext ctx) {
        Operation operation = (Operation) visit(ctx.operator());
        return switch(operation.getOperationType()) {
            case Operation.OPERATOR -> applyOperator(operation.getOperator(), ctx.expression());
            case Operation.FUNCTION_CALL -> applyFunctionCall(operation.getFunctionName(), ctx.expression());
            default -> new ExprResult(new Value(null));
        };
    }

    private ExprResult applyOperator(int operator,
                                     List<BasicEvaluatorParser.ExpressionContext> expressions) {
        int numOperands = expressions.size();
        if (numOperands == 2)
        {
            ExprResult left = (ExprResult) visit(expressions.get(0));
            Value leftValue = left.getResult();
            ExprResult right = (ExprResult) visit(expressions.get(1));
            Value rightValue = right.getResult();

            switch (operator) {
                case BasicEvaluatorParser.ADD -> {
                    return new ExprResult(new Value(leftValue.getValue() + rightValue.getValue()));
                }

                case BasicEvaluatorParser.SUB -> {
                    return new ExprResult(new Value(leftValue.getValue() - rightValue.getValue()));
                }

                case BasicEvaluatorParser.MUL -> {
                    return new ExprResult(new Value(leftValue.getValue() * rightValue.getValue()));
                }

                case BasicEvaluatorParser.DIV -> {
                    return new ExprResult(new Value(leftValue.getValue() / rightValue.getValue()));
                }

                case BasicEvaluatorParser.EQ -> {
                    return new ExprResult(Objects.equals(leftValue.getValue(), rightValue.getValue())
                            ? Value.TRUE
                            : Value.FALSE);
                }

                case BasicEvaluatorParser.LT -> {
                    return new ExprResult(leftValue.getValue() < rightValue.getValue()
                            ? Value.TRUE
                            : Value.FALSE);
                }

                case BasicEvaluatorParser.GT -> {
                    return new ExprResult(leftValue.getValue() > rightValue.getValue()
                            ? Value.TRUE
                            : Value.FALSE);
                }

                default -> {
                    System.out.println("Invalid operator");
                    return new ExprResult(new Value(null));
                }
            }
        } else if (numOperands == 1) {
            ExprResult operand = (ExprResult) visit(expressions.get(0));
            if (operator == BasicEvaluatorParser.PRINT) {
                System.out.println(operand.getResult().getValue());
                return operand;
            }

            System.out.println("Invalid operator");
            return new ExprResult(new Value(null));
        } else {
            System.out.println("Invalid number of operands for operator");
            return new ExprResult(new Value(null));
        }
    }

    private ExprResult applyFunctionCall(String functionName,
                                         List<BasicEvaluatorParser.ExpressionContext> expressions) {
        FunctionDefinition function = memory.getFunction(functionName);
        if (function != null) {
            // Step #1: check actual arg count with formal arg count
            int argCount = function.argumentList.size();
            if (argCount != expressions.size()) {
                System.out.println("Wrong number of arguments to: " + functionName);
                return new ExprResult(new Value(null));
            }

            // Step #2: get values of actual arguments
            Value[] actualArgs = new Value[argCount];
            for (int i = 0; i < argCount; i++) { // argCount == expressions.size()
                ExprResult argValue = (ExprResult) visit(expressions.get(i));
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
            System.out.println("Undefined function: " + functionName);
            return new ExprResult(new Value(null));
        }
    }
}
