package BasicEvaluatorInterpreter;

public class Operator extends Operation {
    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return this.operator;
    }
}
