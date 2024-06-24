package wordle.domain;

import java.util.Objects;

public class Letter implements Comparable<Letter> {

    private final Alphabet alphabet;
    private final Position position;

    public Letter(final char alphabet, final int position) {
        this.alphabet = new Alphabet(alphabet);
        this.position = new Position(position);
    }

    public boolean isSameAlphabet(final Letter letter) {
        return letter.alphabet.equals(this.alphabet);
    }

    public boolean isSamePosition(final Letter letter) {
        return letter.position.equals(position);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Letter letter = (Letter) o;
        return Objects.equals(alphabet, letter.alphabet) && Objects.equals(position,
                letter.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alphabet, position);
    }

    @Override
    public int compareTo(final Letter o) {
        return position.compareTo(o.position);
    }
}
