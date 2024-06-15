package wordle;

public class WordleValidator {
    private static final int VALID_LENGTH = 5;

    public boolean isInvalidLength(Input inputClass) {
        return inputClass.lessThan(VALID_LENGTH);
    }

    public boolean isNotIncludedWord(Input input, Words words) {
        return words.notContains(input.getValue());
    }
}
