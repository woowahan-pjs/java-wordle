package domain;

public enum TileColor {

    WHITE("⬜"),

    YELLOW("🟨"),

    GREEN("🟩");

    private final String tile;

    TileColor(String tile) {
        this.tile = tile;
    }
}
