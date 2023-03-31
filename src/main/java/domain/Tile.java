package domain;

public enum Tile {
    GREEN("\uD83D\uDFE9"), YELLOW("\uD83D\uDFE8"), GRAY("⬜");

    private final String tile;

    Tile(String tile) {
        this.tile = tile;
    }

    public boolean isNotWrong() {
        return this != GRAY;
    }
}
