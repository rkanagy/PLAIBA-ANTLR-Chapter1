public record Value(Integer value) {
    public static final Value TRUE = new Value(1);
    public static final Value FALSE = new Value(0);

    public Integer getValue() {
        return this.value;
    }

    public boolean isDefined() {
        return this.value != null;
    }

    public boolean isTrue() {
        return this.getValue() != 0;
    }

    public boolean isFalse() {
        return this.getValue() == 0;
    }
}
