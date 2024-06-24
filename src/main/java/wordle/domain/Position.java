package wordle.domain;

import java.util.Objects;
import wordle.exception.InvalidPositionException;

public class Position implements Comparable<Position> {

    private static final int MIN_POSITION = 0;
    private final int position;

    public Position(int position) {
        if (position < MIN_POSITION) {
            throw new InvalidPositionException();
        }

        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.position, position.position);
    }
}
