package BasicEvaluatorInterpreter;

public class FunctionCall extends Operation {
    private final String functionName;

    public FunctionCall(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return this.functionName;
    }
}
