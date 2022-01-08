import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BasicEvaluator {
    public static void main(String[] args) throws Exception {
        String inputFile;
        CharStream input;
        SymbolTable globalEnv = new SymbolTable();
        FunctionTable functions = new FunctionTable();
        if (args.length > 0) { // input from file
            inputFile = args[0];
            InputStream is = new FileInputStream(inputFile);
            input = CharStreams.fromStream(is);
            parse(input, globalEnv, functions);
        } else { // REPL
            boolean quittingTime = false;
            while (!quittingTime) {
                String strInput = getInput();
                input = CharStreams.fromString(strInput);

                if (strInput.equals("quit"))
                    quittingTime = true;
                else if (strInput.equals("clear")) {
                    globalEnv.clearSymbols();
                    functions.clear();
                    System.out.println("Variables and Functions cleared");
                } else {
                    parse(input, globalEnv, functions);
                }
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

    private static void parse(CharStream input, SymbolTable globalEnv, FunctionTable functions) {
        BasicEvaluatorLexer lexer = new BasicEvaluatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BasicEvaluatorParser parser = new BasicEvaluatorParser(tokens);
        ParseTree tree = parser.prog();

        BasicEvaluatorVisitorImpl visitor = new BasicEvaluatorVisitorImpl(globalEnv, functions);
        visitor.visit(tree);
    }
}
