package domain;

public enum Hint {

    CORRECT("🟩"),           //\uD83D\\uDFE9
    EXIST("🟨"),              //\uD83D\\uDFE8
    NOT_EXIST("⬜");

    private final String tile;

    Hint(String tile) {
        this.tile = tile;
    }

    public String getTile() {
        return tile;
    }

    public boolean isCorrect() {
        return this == CORRECT;
    }
}
