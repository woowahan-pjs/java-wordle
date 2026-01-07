package kr.co.wordle.domain;

public enum Tile {
    GREEN("🟩"),
    YELLOW("🟨"),
    GRAY("⬜️");

    private final String text;

    Tile(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
