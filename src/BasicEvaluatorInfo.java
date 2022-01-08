public class BasicEvaluatorInfo {
    private String functionName;
    private Value expressionValue;

    public BasicEvaluatorInfo(String functionName) {
        this.functionName = functionName;
    }

    public BasicEvaluatorInfo(Value value) {
        this.expressionValue = value;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public Value getExpressionValue() {
        return this.expressionValue;
    }
}
