package wordle.model;

import java.util.Arrays;

public class Word {

	private static final int VALID_WORD_LENGTH = 5;
	private static final int NUMBER_OF_LETTER = 5;
	private static final String INVALID_WORD_LENGTH_MESSAGE = "단어는 5글자여야 합니다.";
	private final Letter[] letters = new Letter[NUMBER_OF_LETTER];

	private Word() {

	}

	public static Word from(String input) {
		Word word = new Word();
		word.validateInputWordLength(input);
		word.createLetters(input);
		return word;
	}


	public Letter[] getLetters() {
		return letters;
	}

	private void validateInputWordLength(String input) {
		if (input.length() != VALID_WORD_LENGTH) {
			throw new IllegalArgumentException(INVALID_WORD_LENGTH_MESSAGE);
		}
	}

	private void createLetters(String input) {
		for (int index = 0; index < input.length(); index++) {
			letters[index] = new Letter(input.charAt(index));
		}
	}

	public Tiles calculateMatched(Word userInputWord) {
		TileStatus[] tileStatuses = new TileStatus[NUMBER_OF_LETTER];
		Letter[] userInputLetters = userInputWord.getLetters();

		for (int index = 0; index < VALID_WORD_LENGTH; index++) {
			tileStatuses[index] = checkGreen(userInputLetters[index], index);
		}

		for (int index = 0; index < VALID_WORD_LENGTH; index++) {
			if (tileStatuses[index] != TileStatus.GREEN) {
				tileStatuses[index] = checkYellowOrGray(userInputLetters[index]);
			}
		}

		return new Tiles(tileStatuses);
	}

	private TileStatus checkGreen(Letter userInputLetters, int index) {
		if (letters[index].equals(userInputLetters)) {
			letters[index].setMatched();
			return TileStatus.GREEN;
		}
		return TileStatus.GRAY;
	}

	private TileStatus checkYellowOrGray(Letter userInput) {
		for (int index = 0; index < VALID_WORD_LENGTH; index++) {
			if (letters[index].equals(userInput) && !letters[index].isMatched()) {
				letters[index].setMatched();
				return TileStatus.YELLOW;
			}
		}
		return TileStatus.GRAY;
	}

	public void clearAllMatched() {
		for (Letter letter : letters) {
			letter.setUnmatched();
		}
	}

	public String getAnswerWordAsString() {
		StringBuilder sb = new StringBuilder();
		for (Letter letter : letters) {
			sb.append(letter.getAlphabet());
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Word word = (Word) o;
		return Arrays.equals(letters, word.letters);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(letters);
	}
}
