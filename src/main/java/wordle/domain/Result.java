package wordle.domain;

public enum Result {
    CORRECT("\uD83D\uDFE9"),
    HALF_CORRECT("\uD83D\uDFE8"),
    WRONG("⬜"),
    ;

    private final String cell;

    Result(final String cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return cell;
    }
}
