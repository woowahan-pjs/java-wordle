package wordle.domain;

import java.util.Objects;

public class Result implements Comparable<Result> {

    private final Tile tile;
    private final Letter letter;

    public Result(final Tile tile, final Letter letter) {
        this.tile = tile;
        this.letter = letter;
    }

    public boolean isSamePosition(final Letter letter) {
        return this.letter.isSamePosition(letter);
    }

    public boolean isGreen() {
        return this.tile == Tile.GREEN;
    }

    public boolean isYellow() {
        return this.tile == Tile.YELLOW;
    }

    public boolean isGray() {
        return this.tile == Tile.GRAY;
    }

    @Override
    public int compareTo(final Result o) {
        return letter.compareTo(o.letter);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Result result = (Result) o;
        return tile == result.tile && Objects.equals(letter, result.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tile, letter);
    }
}
