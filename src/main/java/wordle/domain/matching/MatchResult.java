package wordle.domain.matching;

import wordle.domain.word.WordCondition;

public enum MatchResult {

    GREEN("🟩"),
    YELLOW("🟨"),
    GRAY("⬜"),
    ;

    private static final String CORRECT_ANSWER_LINE = GREEN.value().repeat(WordCondition.WORD_LENGTH.value());

    private final String value;

    MatchResult(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static String getCorrectAnswerLine() {
        return CORRECT_ANSWER_LINE;
    }
}
