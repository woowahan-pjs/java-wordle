package woowaapplication.pair.game.wordle;

public class KeywordValidator {

    public static boolean validate(String keyword, int lengthLimit) {
        if (keyword == null) {
            return false;
        }

        return isAlphabetic(keyword) && isLengthValid(keyword, lengthLimit);
    }

    private static boolean isAlphabetic(String keyword) {
        return keyword.matches("[a-zA-Z]+");
    }

    private static boolean isLengthValid(String keyword, int length) {
        return keyword.length() == length;
    }
}
