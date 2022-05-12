package wordle.util;

import wordle.model.WordPool;
import wordle.view.ConsoleOutput;

public class WordValidator {

	private static final int WORD_LENGTH = 5;
	private static final String INVALID_LENGTH_MESSAGE = "단어는 5글자로 구성되어야 합니다.";
	private static final String INVALID_ALPHABET_MESSAGE = "단어는 영문자로 구성되어야 합니다.";
	private static final String WORD_PATTERN = "^[A-Za-z]+$";
	private static final String INVALID_WORD_MESSAGE = "존재하지 않는 단어입니다.";

	public static boolean validate(String userInput, WordPool wordPool) {
		try {
			validateWordLength(userInput);
			validateAlphabet(userInput);
			validateExistedWord(userInput, wordPool);
		} catch (Exception e) {
			ConsoleOutput.printErrorMessage(e.getMessage());
			return false;
		}

		return true;
	}

	private static void validateWordLength(String userInput) {
		if (userInput.length() != WORD_LENGTH) {
			throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
		}
	}

	private static void validateAlphabet(String userInput) {
		if (!userInput.matches(WORD_PATTERN)) {
			throw new IllegalArgumentException(INVALID_ALPHABET_MESSAGE);
		}
	}

	private static void validateExistedWord(String userInput, WordPool wordPool) {
		if (!wordPool.contains(userInput)) {
			throw new IllegalArgumentException(INVALID_WORD_MESSAGE);
		}
	}
}
