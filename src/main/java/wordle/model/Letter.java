package wordle.model;

import java.util.List;

public class Letter {

	public static final int MINIMUM_POSITION = 1;
	public static final int MAXIMUM_POSITION = 5;
	public static final String INVALID_ALPHABET_MESSAGE = "유효하지 않은 단어입니다.";
	public static final String INVALID_POSITION_MESSAGE = "유효하지 않은 위치입니다.";

	private char alphabet;
	private int position;

	public Letter(char alphabet, int position) {
		init(alphabet, position);
	}

	private void init(char alphabet, int position) {
		isAlphabet(alphabet);
		this.alphabet = Character.toLowerCase(alphabet);
		isValidRange(position);
		this.position = position;
	}

	// todo
	public TileStatus compareResult(List<Letter> letters) {
		return TileStatus.GRAY;
	}

	private void isAlphabet(char alphabet) {
		if (alphabet >= 'a' && alphabet <= 'z') {
			return;
		}
		if (alphabet >= 'A' && alphabet <= 'Z') {
			return;
		}
		throw new IllegalArgumentException(INVALID_ALPHABET_MESSAGE);
	}

	private void isValidRange(int position) {
		if (!(MINIMUM_POSITION <= position && position <= MAXIMUM_POSITION)) {
			throw new IllegalArgumentException(INVALID_POSITION_MESSAGE);
		}
	}
}
