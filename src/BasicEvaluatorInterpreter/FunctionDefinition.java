package BasicEvaluatorInterpreter;

import java.util.ArrayList;

import BasicEvaluatorParser.*;

public class FunctionDefinition {
    public FunctionDefinition() {
        argumentList = new ArrayList<>();
    }

    public String name;

    public ArrayList<String> argumentList;

    public BasicEvaluatorParser.ExpressionContext expression;
}
