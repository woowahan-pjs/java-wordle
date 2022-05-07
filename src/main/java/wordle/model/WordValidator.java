package wordle.model;

public class WordValidator {

	private static final int WORD_LENGTH = 5;
	private static final String WORD_PATTERN = "^[A-Za-z]+$";

	public static boolean validate(String userInput, WordPool wordPool) {
		if (!isFiveLetterWord(userInput)) {
			throw new IllegalArgumentException(Message.INVALID_WORD_LENGTH_MESSAGE);
		}
		if (!hasEnglishLetterOnly(userInput)) {
			throw new IllegalArgumentException(Message.INVALID_ENGLISH_ALPHABET_MESSAGE);
		}
		if (!existedWord(wordPool, userInput)) {
			throw new IllegalArgumentException(Message.INVALID_WORD_MESSAGE);
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
