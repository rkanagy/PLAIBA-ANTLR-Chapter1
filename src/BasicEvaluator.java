import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import BasicEvaluatorParser.*;
import BasicEvaluatorInterpreter.*;

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
            } else {
                parseInput(strInput, memory);
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

    private static void parseInput(String strInput, Memory memory) {
        try {
            BasicEvaluatorParser parser = getParser(strInput);
            ParseTree tree = parser.prog();

            BasicEvaluatorVisitorImpl visitor = new BasicEvaluatorVisitorImpl(memory);
            EvaluatorInput result = visitor.visit(tree);

            if (result instanceof FunctionDef functionDef) {
                String functionName = functionDef.getName();
                if (functionName != null && functionName.trim().length() > 0) {
                    System.out.println(functionName);
                }
            } else if (result instanceof ExprResult exprResult) {
                Value value = exprResult.getResult();
                if (value != null && value.isDefined()) {
                    System.out.println(value.getValue());
                }
            }
        } catch (InterpreterException err) {
            System.out.println(err.getMessage());
        }
        System.out.println();
    }

    private static BasicEvaluatorParser getParser(String strInput) {
        CharStream input = CharStreams.fromString(strInput);
        BasicEvaluatorLexer lexer = new BasicEvaluatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new BasicEvaluatorParser(tokens);
    }
}
