package wordle.domain.vo;

public enum Color {
    GREEN("\uD83D\uDFE9"),
    YELLOW("\uD83D\uDFE8"),
    GRAY("\u2B1C");

    private final String box;

    Color(String box) {
        this.box = box;
    }

    public String getBox() {
        return box;
    }
}
