package BasicEvaluatorInterpreter;

import java.util.HashMap;
import java.util.Map;

public class ValueEnvironment {
    private final Map<String, Value> environment = new HashMap<>();

    public Value getValue(String name) {
        return environment.get(name);
    }

    public void putValue(String name, Value value) {
        environment.put(name, value);
    }

    public boolean isBound(String name) {
        return environment.containsKey(name);
    }

    public void clearValues() {
        environment.clear();
    }
}
