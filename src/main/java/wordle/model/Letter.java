package wordle.model;

import java.util.Objects;

public class Letter {

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
		WordValidator.isAlphabet(alphabet);
		this.alphabet = Character.toLowerCase(alphabet);
	}
}
