package domain;

public enum Hint {

    CORRECT("🟩"),           //\uD83D\\uDFE9
    EXIST("🟨"),              //\uD83D\\uDFE8
    NOT_EXIST("⬜");

    private final String hint;

    Hint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }
}
