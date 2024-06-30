package wordle.domain;

import java.util.Objects;

public class Letter {

    private final Alphabet alphabet;
    private final Position position;

    public Letter(final char alphabet, final int position) {
        this.alphabet = new Alphabet(alphabet);
        this.position = new Position(position);
    }

    public boolean isSameAlphabet(Letter letter) {
        return letter.alphabet.equals(this.alphabet);
    }

    public Position getPosition() {
        return position;
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
        return Objects.equals(alphabet, letter.alphabet) && Objects.equals(position,
                letter.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alphabet, position);
    }
}
