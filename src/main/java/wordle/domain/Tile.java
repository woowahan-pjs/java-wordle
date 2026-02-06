package wordle.domain;

public enum Tile {
    GREEN("🟩"),
    YELLOW("🟨"),
    GRAY("⬜");

    private final String color;

    Tile(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
