package wordle.domain.word;

public enum WordCondition {
    WORD_LENGTH(5),
    MAX_TRY_COUNT(6),
    ;

    private final int value;

    public int value() {
        return value;
    }

    WordCondition(int value) {
        this.value = value;
    }
}
