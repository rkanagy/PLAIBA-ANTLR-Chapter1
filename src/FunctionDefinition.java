import java.util.ArrayList;

public class FunctionDefinition {
    public FunctionDefinition() {
        argumentList = new ArrayList<>();
    }

    public ArrayList<String> argumentList;

    public BasicEvaluatorParser.ExpressionContext expression;
}
