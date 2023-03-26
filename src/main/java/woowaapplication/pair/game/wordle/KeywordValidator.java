package woowaapplication.pair.game.wordle;

public class KeywordValidator {
    public static boolean validate(String keyword, int length) {
        if (keyword == null) {
            return false;
        }

        return isAlphabetic(keyword) && isLengthValid(keyword, length);
    }

    private static boolean isAlphabetic(String keyword) {
        return keyword.matches("[a-zA-Z]+");
    }

    private static boolean isLengthValid(String keyword, int length) {
        return keyword.length() == length;
    }
}
