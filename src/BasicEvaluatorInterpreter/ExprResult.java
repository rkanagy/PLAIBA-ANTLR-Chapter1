package BasicEvaluatorInterpreter;

public class ExprResult extends Expression {
    private final Value result;

    public ExprResult(Value result) {
        this.result = result;
    }

    public Value getResult() { return this.result; }
}
