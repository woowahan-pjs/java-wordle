package wordle.domain;

import java.util.Objects;

public class Result implements Comparable<Result> {

    private final Tile tile;
    private final Position position;

    public Result(Tile tile, int position) {
        this(tile, new Position(position));
    }

    public Result(Tile tile, Position position) {
        this.tile = tile;
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
        Result result = (Result) o;
        return tile == result.tile && Objects.equals(position, result.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tile, position);
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public int compareTo(Result o) {
        return position.compareTo(o.position);
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
}
