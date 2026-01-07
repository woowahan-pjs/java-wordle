package domain;

public enum Tile {
    GREEN("\uD83D\uDFE9"), YELLOW("\uD83D\uDFE8"), GRAY("⬜");

    private final String tile;

    Tile(String tile) {
        this.tile = tile;
    }

    public String getTile() {
        return tile;
    }

    public static Tile getTile(Long count, Letter answerLetter, Letter letter) {
        if (count == null || count <= 0) {
            return Tile.GRAY;
        }
        if (answerLetter.equals(letter)) {
            return Tile.GREEN;
        }
        return Tile.YELLOW;
    }
}
