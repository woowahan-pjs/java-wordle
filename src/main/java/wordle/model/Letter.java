package wordle.model;

import java.util.Objects;

public class Letter {

	private static final String INVALID_ALPHABET_MESSAGE = "유효하지 않은 단어입니다.";
	private char alphabet;
	private boolean matched = false;

	public Letter(char alphabet) {
		init(alphabet);
	}

	public char getAlphabet() {
		return alphabet;
	}

	public void setMatched() {
		this.matched = true;
	}

	public void setUnmatched() {
		this.matched = false;
	}

	public boolean isMatched() {
		return this.matched;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Letter letter = (Letter) o;
		return alphabet == letter.alphabet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alphabet);
	}

	private void init(char alphabet) {
		if(!isAlphabet(alphabet)) {
			throw new IllegalArgumentException(INVALID_ALPHABET_MESSAGE);
		}
		this.alphabet = Character.toLowerCase(alphabet);
	}

	private boolean isAlphabet(char alphabet) {
		return (alphabet >= 'a' && alphabet <= 'z') || (alphabet >= 'A' && alphabet <= 'Z');
	}
}
