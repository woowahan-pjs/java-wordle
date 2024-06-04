package woowaapplication.pair.game.wordle;

import woowaapplication.pair.game.wordle.exception.InvalidInputKeywordException;

public class KeywordValidator {

    public static void validate(String keyword, int lengthLimit) {
        if (keyword == null) {
            throw new InvalidInputKeywordException();
        }

        if (!isAlphabetic(keyword)) {
            throw new InvalidInputKeywordException();
        }

        if (!isLengthValid(keyword, lengthLimit)) {
            throw new InvalidInputKeywordException();
        }
    }

    private static boolean isAlphabetic(String keyword) {
        return keyword.matches("[a-zA-Z]+");
    }

    private static boolean isLengthValid(String keyword, int length) {
        return keyword.length() == length;
    }
}
