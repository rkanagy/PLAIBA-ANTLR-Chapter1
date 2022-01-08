public class Value {
    private final Object value;

    public Value(String value) {
        this.value = value;
    }

    public Value(long value) {
        this.value = value;
    }

    public long numberValue() {
        return (long)value;
    }

    public static final Value TRUE = new Value(1);
    public static final Value FALSE = new Value(0);

    public String stringValue() {
        return (String)value;
    }

    public boolean isNumberValue() {
        return value instanceof Long;
    }

    public boolean isStringValue() {
        return value instanceof String;
    }

    public boolean isDefined() { return value != null; }

    public boolean isTrue() {
        return numberValue() != 0;
    }

    public boolean isFalse() {
        return numberValue() == 0;
    }
}
