package wordle.model;

import java.util.Arrays;

public class Word {

	private static final int VALID_WORD_LENGTH = 5;
	private static final int NUMBER_OF_LETTER = 5;
	private Letter[] letters = new Letter[NUMBER_OF_LETTER];

	public Word(String input) {
		validateInputWordLength(input);
		createLetters(input);
	}

	public Letter[] getLetters() {
		return letters;
	}

	private void validateInputWordLength(String input) {
		if (input.length() != VALID_WORD_LENGTH) {
			throw new IllegalArgumentException(GameMessage.INVALID_WORD_LENGTH_MESSAGE);
		}
	}

	private void createLetters(String input) {
		for (int index = 0; index < input.length(); index++) {
			letters[index] = new Letter(input.charAt(index));
		}
	}

	public TileLine calculateMatched(Word userInputWord) {
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

		return new TileLine(tileStatuses);
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
