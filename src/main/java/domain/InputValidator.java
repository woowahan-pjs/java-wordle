package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern ENGLISH_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private static final int INPUT_WORD_LENGTH = 5;

    public boolean validateEnglish(String input) {
        Matcher matcher = ENGLISH_PATTERN.matcher(input);
        return matcher.matches();
    }

    public boolean validateLength(String input) {
        String trim = input.trim();
        return trim.length() == INPUT_WORD_LENGTH;
    }
}
