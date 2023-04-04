package wordle.domain.word;

import java.util.Objects;

public class PositionLetter {
    private final Position position;
    private final Letter letter;

    public PositionLetter(Position position, Letter letter) {
        this.position = position;
        this.letter = letter;
    }

    public static PositionLetter of(int position, char letter) {
        return new PositionLetter(Position.from(position), Letter.from(letter));
    }

    public boolean hasSameValueAndDiffPosition(PositionLetter target) {
        return letter.equals(target.letter) && !position.equals(target.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionLetter that = (PositionLetter) o;
        return Objects.equals(position, that.position) && Objects.equals(letter, that.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, letter);
    }
}
