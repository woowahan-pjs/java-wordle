package wordle.util;

public class Validator {

	private static final int WORD_LENGTH = 5;
	private static final String WORD_PATTERN = "^[A-Za-z]+$";

	public boolean validate(String userInput) {
		// 글자 수가 5자가 아닌 경우
		if (!validateWordLength(userInput)) {
			return false;
		}
		// 입력된 단어가 영문자로만 구성되어 있는지
		if (!validateAlphabet(userInput)) {
			return false;
		}
		// TODO: 단어 목록에 일치하는 단어가 있는지 없는지
		return true;
	}

	private boolean validateWordLength(String userInput) {
		return userInput.length() == WORD_LENGTH;
	}

	private boolean validateAlphabet(String userInput) {
		return userInput.matches(WORD_PATTERN);
	}
}
