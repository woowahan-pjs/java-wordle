package wordle.model;

import wordle.view.ConsoleOutput;

public class WordValidator {

	private static final int WORD_LENGTH = 5;
	private static final String WORD_PATTERN = "^[A-Za-z]+$";

	public static boolean validate(String userInput, WordPool wordPool) {
		if (!isFiveLetterWord(userInput)) {
			ConsoleOutput.printInvalidLengthMessage();
			return false;
		}
		if (!hasEnglishLetterOnly(userInput)) {
			ConsoleOutput.printInvalidAlphabetMessage();
			return false;
		}
		if (!existedWord(wordPool, userInput)) {
			ConsoleOutput.printInvalidWordMessage();
			return false;
		}
		return true;
	}

	public static boolean hasEnglishLetterOnly(String userInput) {
		return userInput.matches(WORD_PATTERN);
	}

	private static boolean isFiveLetterWord(String userInput) {
		return userInput.length() == WORD_LENGTH;
	}

	private static boolean existedWord(WordPool wordPool, String userInput) {
		return wordPool.contains(userInput);
	}

	public static boolean isAlphabet(char character) {
		return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
	}
}
