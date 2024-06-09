package wordle.domain;

import java.util.Objects;

public class Result {
    private final Tile tile;
    private final Position position;

    public Result(Tile tile, int position) {
        this.tile = tile;
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
        Result result = (Result) o;
        return tile == result.tile && Objects.equals(position, result.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tile, position);
    }
}
