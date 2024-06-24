package wordle.domain;

import java.util.Objects;

public class ResultV2 implements Comparable<ResultV2> {

    private final Tile tile;
    private final Letter letter;

    public ResultV2(final Tile tile, final Letter letter) {
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
    public int compareTo(final ResultV2 o) {
        return letter.compareTo(o.letter);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ResultV2 resultV2 = (ResultV2) o;
        return tile == resultV2.tile && Objects.equals(letter, resultV2.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tile, letter);
    }
}
