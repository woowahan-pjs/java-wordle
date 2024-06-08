package wordle.domain;

public class Result {
    private final Tile tile;
    private final Position position;

    public Result(Tile tile, int position) {
        this.tile = tile;
        this.position = new Position(position);
    }
}
