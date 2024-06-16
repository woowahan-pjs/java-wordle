package domain;

public enum Hint {

    CORRECT("🟩"),           //\uD83D\\uDFE9
    EXIST("🟨"),              //\uD83D\\uDFE8
    NOT_EXIST("⬜");

    private final String tile;

    Hint(String hint) {
        this.tile = hint;
    }

    public String getTile() {
        return tile;
    }

    public static boolean isCorrect(Hint hint) {
        return Hint.CORRECT.equals(hint);
    }
}
