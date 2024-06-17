package wordle.model;

public class WordleValidator {

    private static final int VALID_SIZE = 5;

    public boolean isInvalidLength(Letters letters) {
        return letters.lessThan(VALID_SIZE) || letters.higherThan(VALID_SIZE);
    }

    public boolean isNotIncludedWord(Letters letters, Words words) {
        return words.notContains(letters.combine());
    }
}
