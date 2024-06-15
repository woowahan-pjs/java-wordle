package kr.co.wordle;

import java.util.List;

import static kr.co.wordle.WordleGameConfig.WORD_LENGTH;

public class InputValidator {

    private InputValidator() {
    }

    public static boolean isNotValidateInput(String input) {
        if (input == null) {
            return true;
        }
        if (input.length() != WORD_LENGTH) {
            return true;
        }
        if (isNotAllAlphabet(input)) {
            return true;
        }
        return isNotInWords(input);
    }

    public static boolean isNotAllAlphabet(String input) {
        return input.chars().anyMatch(ch -> ch < 'a' || ch > 'z');
    }

    public static boolean isNotInWords(String input) {
        return !words.contains(input);
    }
}
