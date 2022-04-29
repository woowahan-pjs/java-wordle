package domain;

import java.util.Objects;

public class Letter {

    private final Character letter;

    public Letter(Character letter) {
        this.letter = letter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter1 = (Letter) o;
        return Objects.equals(letter, letter1.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter);
    }
}
