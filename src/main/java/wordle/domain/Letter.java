package wordle.domain;

import java.util.Objects;

public class Letter {

    private char alphabet;
    private Position position;

    public Letter(char alphabet, int position) {
        this.alphabet = alphabet;
        this.position = new Position(position);
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
        return alphabet == letter.alphabet && Objects.equals(position, letter.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alphabet, position);
    }

    public boolean isSameAlphabet(Letter letter) {
        return letter.alphabet == this.alphabet;
    }

    public Position getPosition() {
        return position;
    }
}
