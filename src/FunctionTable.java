import java.util.HashMap;
import java.util.Map;

public class FunctionTable {
    private final Map<String, FunctionDefinition> functions = new HashMap<>();

    public FunctionDefinition get(String functionName) {
        return functions.get(functionName);
    }

    public void set(String functionName, FunctionDefinition functionDef) {
        functions.put(functionName, functionDef);
    }

    public void clear() {
        functions.clear();
    }
}
