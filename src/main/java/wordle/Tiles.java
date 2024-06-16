package wordle;

public class Tiles {

    private static final String GRAY_TILE = "⬜";
    private static final String YELLOW_TILE = "\uD83D\uDFE8";
    private static final String GREEN_TILE = "\uD83D\uDFE9";

    private final String[] tiles;

    public Tiles(int size) {
        this.tiles = new String[size];
    }

    public void addGreenTile(Letters letters) {
        for(Letter letter : letters.getLetters()) {
            tiles[letter.getPosition()] = GREEN_TILE;
        }
    }

    public void addYellowTile(Letters letters) {
        for(Letter letter : letters.getLetters()) {
            tiles[letter.getPosition()] = YELLOW_TILE;
        }
    }

    public void addGrayTile(Letters letters) {
        for (Letter letter : letters.getLetters()) {
            tiles[letter.getPosition()] = GRAY_TILE;
        }
    }

    @Override
    public String toString() {
        return String.join("", tiles);
    }
}
