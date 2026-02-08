package model;

public enum TileColor {

    WHITE("⬜"),
    YELLOW("🟨"),
    GREEN("🟩");

    private final String emoji;

    TileColor(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
}
