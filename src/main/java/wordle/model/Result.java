package wordle.model;

import java.util.Arrays;
import java.util.List;

public class Result {

    private static final String GRAY_TILE = "⬜";
    private static final String YELLOW_TILE = "\uD83D\uDFE8";
    private static final String GREEN_TILE = "\uD83D\uDFE9";

    private final String[] tiles;

    public Result(int size) {
        this.tiles = new String[size];
        Arrays.fill(tiles, GRAY_TILE);
    }

    public void addGreenTile(Letters letters) {
        for(Letter letter : letters) {
            tiles[letter.getPosition()] = GREEN_TILE;
        }
    }

    public void addYellowTile(Letters letters) {
        for(Letter letter : letters) {
            tiles[letter.getPosition()] = YELLOW_TILE;
        }
    }

    public boolean isAnswer() {
        return Arrays.stream(tiles)
                .allMatch(tile -> tile.equals(GREEN_TILE));
    }

    public List<String> getTiles() {
        return List.of(tiles);
    }
}
