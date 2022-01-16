package BasicEvaluatorInterpreter;

public class InterpreterException extends RuntimeException {
    public InterpreterException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
