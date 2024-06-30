package wordle.model;

public class WordleValidator {

    private static final int VALID_SIZE = 5;

    public boolean isInvalidLength(String input) {
        return input.length() < VALID_SIZE || input.length() > VALID_SIZE;
    }

    public boolean isNotIncludedWord(String input, Words words) {
        return words.notContains(input);
    }
}
