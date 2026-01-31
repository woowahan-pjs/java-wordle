package wordle.domain;

public enum Tile {
    GREEN("\uD83D\uDFE9"),
    YELLOW("\uD83D\uDFE8"),
    GRAY("⬜");

    private final String color;

    Tile(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
