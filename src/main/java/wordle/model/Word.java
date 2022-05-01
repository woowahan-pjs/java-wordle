package wordle.model;

public class Word {

	private static final int VALID_WORD_LENGTH = 5;
	private static final int NUMBER_OF_LETTER = 5;
	private static final String INVALID_WORD_LENGTH_MESSAGE = "단어는 5글자여야 합니다.";
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
			if (letters[index].equals(userInputLetters[index])) {
				letters[index].setMatched(); // false -> true;
				tileStatuses[index] = TileStatus.GREEN;
			}
		}

		for (int index = 0; index < VALID_WORD_LENGTH; index++) {
			if (tileStatuses[index] != TileStatus.GREEN) {
				tileStatuses[index] = compare(userInputLetters[index]);
			}
		}

		return new Tiles(tileStatuses);
	}

	private TileStatus compare(Letter userInput) {
		for (int index = 0; index < VALID_WORD_LENGTH; index++) {
			if (letters[index].equals(userInput) && !letters[index].isMatched()) {
				letters[index].setMatched(); // false -> true;
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
}
