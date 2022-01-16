package BasicEvaluatorInterpreter;

public class Variable extends Expression {
    private final String variableName;

    public Variable(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return this.variableName;
    }
}
