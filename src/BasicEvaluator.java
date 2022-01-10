import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BasicEvaluator {
    public static void main(String[] args) throws Exception {
        Memory memory = new Memory();

        // Read-Evaluate-Print Loop
        boolean quittingTime = false;
        while (!quittingTime) {
            String strInput = getInput();

            if (strInput.trim().equals("quit"))
                quittingTime = true;
            else if (strInput.trim().equals("clear")) {
                memory.clear();
            } else if (strInput.trim().startsWith("define", 1)) {
                parseDefinition(strInput, memory);
            } else {
                parseExpression(strInput, memory);
            }
        }

    }

    private static String getInput() throws IOException {
        int paren_count = 0;
        String prompt = "-> ";
        List<String> lines = new ArrayList<>();

        do {
            System.out.print(prompt);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            line = line.stripTrailing();

            for (int i = 0; i < line.length(); i++) {
                char chr = line.charAt(i);
                if (chr == '(')
                    paren_count++;
                else if (chr == ')')
                    paren_count--;
            }
            lines.add(line);
            prompt = "> ";
        } while (paren_count != 0);

        return String.join("\n", lines);
    }

    private static void parseDefinition(String strInput, Memory memory) {
        BasicEvaluatorParser parser = getParser(strInput);
        ParseTree tree = parser.funDef();

        BasicEvaluatorVisitorImpl visitor = new BasicEvaluatorVisitorImpl(memory);
        BasicEvaluatorInfo info = visitor.visit(tree);

        if (info != null) {
            String functionName = info.getFunctionName();
            if (functionName != null && functionName.trim().length() > 0) {
                System.out.println(info.getFunctionName());
            }
        }
    }
    private static void parseExpression(String strInput, Memory memory) {
        BasicEvaluatorParser parser = getParser(strInput);
        ParseTree tree = parser.expression();

        BasicEvaluatorVisitorImpl visitor = new BasicEvaluatorVisitorImpl(memory);
        BasicEvaluatorInfo info = visitor.visit(tree);

        Value value = info.getExpressionValue();
        if (value != null && value.isDefined()) {
            System.out.println(value.getValue());
        }
    }

    private static BasicEvaluatorParser getParser(String strInput) {
        CharStream input = CharStreams.fromString(strInput);
        BasicEvaluatorLexer lexer = new BasicEvaluatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new BasicEvaluatorParser(tokens);
    }
}
