package kr.co.wordle;

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
        char[] inputChars = input.toLowerCase().toCharArray();
        for (char ch : inputChars) {
            if (ch < 'a' || ch > 'z') {
                return true;
            }
        }
        return !AnswerProvider.isInputInWords(input);
    }
}
