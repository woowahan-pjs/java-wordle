package wordle.domain.word;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Position {
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 5;
    private static final Map<Integer, Position> cache = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_POSITION, MAX_POSITION)
                .forEach(position -> cache.put(position, new Position(position)));
    }

    private final int value;

    private Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_POSITION || value > MAX_POSITION) {
            throw new IllegalArgumentException(String.format("should be %d < position < %d", MIN_POSITION, MAX_POSITION));
        }
    }

    public static Position from(int value) {
        return cache.get(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
