package wordle.model;

import java.util.ArrayList;
import java.util.List;

public class Word {

	public static final int VALID_WORD_LENGTH = 5;
	public static final String INVALID_WORD_LENGTH_MESSAGE = "단어는 5글자여야 합니다.";
	private List<Letter> letters = new ArrayList<>();

	public Word(String input) {
		validateInputWordLength(input);
		createLetters(input);
	}

	public List<Letter> getLetters() {
		return letters;
	}

	private void validateInputWordLength(String input) {
		if (input.length() != VALID_WORD_LENGTH) {
			throw new IllegalArgumentException(INVALID_WORD_LENGTH_MESSAGE);
		}
	}

	private void createLetters(String input) {
		for (int index = 0; index < input.length(); index++) {
			letters.add(new Letter(input.charAt(index), index + 1));
		}
	}

	public List<Tile> compareWith(Word userInputWord) {
		List<Tile> result = new ArrayList<>();
		for (Letter letter : userInputWord.getLetters()) {
			result.add(new Tile(letter.compareResult(letters)));
		}
		return result;
	}
}
