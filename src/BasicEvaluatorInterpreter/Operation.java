package BasicEvaluatorInterpreter;

public class Operation extends Expression {
    private final String functionName;
    private final int operationType;
    private final int operator;

    public static final int OPERATOR = 0;
    public static final int FUNCTION_CALL = 1;

    public Operation(String name) {
        this.functionName = name;
        this.operationType = FUNCTION_CALL;
        this.operator = -1;
    }

    public Operation(int operator) {
        this.operator = operator;
        this.operationType = OPERATOR;
        this.functionName = null;
    }

    public int getOperationType() { return this.operationType; }
    public String getFunctionName() { return this.functionName; }
    public int getOperator() { return this.operator; }
}
