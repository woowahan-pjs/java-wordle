package wordle.model;

public class WordValidator {

	private static final int WORD_LENGTH = 5;
	private static final String WORD_PATTERN = "^[A-Za-z]+$";

	public static boolean validate(String userInput, WordPool wordPool) {
		validateFiveLetterWord(userInput);
		validateEnglishLetterOnly(userInput);
		validateExistedWord(wordPool, userInput);
		return true;
	}

	public static void validateEnglishLetterOnly(String word) {
		if (!word.matches(WORD_PATTERN)) {
			throw new IllegalArgumentException(Message.INVALID_WORD_LENGTH_MESSAGE);
		}
	}

	public static void validateFiveLetterWord(String word) {
		if (word.length() != WORD_LENGTH) {
			throw new IllegalArgumentException(Message.INVALID_ENGLISH_ALPHABET_MESSAGE);
		}
	}

	private static void validateExistedWord(WordPool wordPool, String word) {
		if (!wordPool.contains(word)) {
			throw new IllegalArgumentException(Message.INVALID_WORD_MESSAGE);
		}
	}

	public static boolean isAlphabet(char character) {
		return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
	}
}
