package kr.co.wordle;

import java.util.List;

import static kr.co.wordle.WordleGameConfig.WORD_LENGTH;

public class InputValidator {

    private static final List<String> words = WordFileReader.readWordsInFile();

    private InputValidator() {
    }

    public static boolean isNotValid(String input) {
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

    private static boolean isNotAllAlphabet(String input) {
        return input.chars().anyMatch(ch -> ch < 'a' || ch > 'z');
    }

    private static boolean isNotInWords(String input) {
        return !words.contains(input);
    }
}
