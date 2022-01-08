import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private final Stack<Map<String, Value>> environment = new Stack<>();

    public SymbolTable() {
        // initialize new global environment
        this.addEnvironment();
    }

    public void addEnvironment() {
        environment.push(new HashMap<>());
    }

    public void removeEnvironment() {
        environment.pop();
    }

    public void clearSymbols() {
        environment.clear();
        this.addEnvironment(); // add global environment back onto stack
    }

    public Value getSymbol(String name) {
        if (environment.empty()) {
            // add global environment
            this.addEnvironment();
        }

        // get value from the closest environment (check local, then global)
        //return environment.elementAt(environment.size() - 1).get(name);
        for (int i = environment.size() - 1; i >= 0; i--) {
            Value value = environment.elementAt(i).get(name);
            if (value != null) return value;
        }
        return null;
    }

    public void setSymbol(String name, Value value) {
        if (!environment.empty()) {
            // add global environment
            this.addEnvironment();
        }

        // put variable and name current environment (local or global)
        //environment.elementAt(environment.size() - 1).put(name, value);
        environment.peek().put(name, value);
    }
}
