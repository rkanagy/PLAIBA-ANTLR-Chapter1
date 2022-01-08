import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Memory {
    private final ValueEnvironment globals = new ValueEnvironment();
    private final Stack<ValueEnvironment> functionStack = new Stack<>();
    private final Map<String, FunctionDefinition> functions = new HashMap<>();

    public void addLocalEnvironment() {
        functionStack.push(new ValueEnvironment());
    }

    public void removeLocalEnvironment() {
        functionStack.pop();
    }

    public void clear() {
        functionStack.clear();
        globals.clearValues();
        functions.clear();
    }

    public Value getSymbol(String name) {
        // Step #1: check top of function stack for symbol
        if (!functionStack.empty()) {
            ValueEnvironment currentFunctionStack = functionStack.peek();
            Value value = currentFunctionStack.getValue(name);
            if (value != null) return value;
        }

        // Step #2: check globals for symbol
        return globals.getValue(name);
    }

    public void setSymbol(String name, Value value) {
        if (!functionStack.empty()) {
            ValueEnvironment functionEnvironment = functionStack.peek();
            if (functionEnvironment.isBound(name)) {
                functionEnvironment.putValue(name, value);
                return;
            }
        }

        globals.putValue(name, value);
    }

    public void setLocalSymbol(String name, Value value) {
        if (!functionStack.empty()) {
            ValueEnvironment functionEnvironment = functionStack.peek();
            functionEnvironment.putValue(name, value);
        }
    }

    public FunctionDefinition getFunction(String functionName) {
        return functions.get(functionName);
    }

    public void setFunction(String functionName, FunctionDefinition functionDef) {
        functions.put(functionName, functionDef);
    }
}
