package wordle;

public class Result {

    private static final String GRAY_TILE = "⬜";
    private static final String YELLOW_TILE = "\uD83D\uDFE8";
    private static final String GREEN_TILE = "\uD83D\uDFE9";

    private final String[] tiles;

    public Result(int size) {
        this.tiles = new String[size];
    }

    public void addGreenTile(int index) {
        tiles[index] = GREEN_TILE;
    }

    public void addGreenTile(Letters letters) {
        for(Letter letter : letters.getLetters()) {
            tiles[letter.getPosition()] = GREEN_TILE;
        }
    }

    public void addYellowTile(int index) {
        tiles[index] = YELLOW_TILE;
    }

    public void addGrayTile(int index) {
        tiles[index] = GRAY_TILE;
    }

    public boolean isNullOrNotGreenTile(int index) {
        return tiles[index] == null || !tiles[index].equals(GREEN_TILE);
    }

    @Override
    public String toString() {
        return String.join("", tiles);
    }

    public void addYellowTile(Letters letters) {
        for(Letter letter : letters.getLetters()) {
            tiles[letter.getPosition()] = YELLOW_TILE;
        }
    }
}
