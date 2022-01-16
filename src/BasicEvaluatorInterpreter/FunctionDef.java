package BasicEvaluatorInterpreter;

public class FunctionDef extends EvaluatorInput {
    private final String name;

    public FunctionDef(String name) {
        this.name = name;
    }

    public String getName() { return this.name; }
}
