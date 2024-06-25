package wordle.domain;

public enum ResultType {
    NONE,
    MATCHED,
    EXIST,
    MISMATCHED;

    public boolean isNotEquals(final ResultType resultType) {
        return this.equals(resultType);
    }
}
