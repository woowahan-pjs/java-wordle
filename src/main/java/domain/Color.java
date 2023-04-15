package domain;

public enum Color {
    GREY("⬜"),
    YELLOW("\uD83D\uDFE8"),
    GREEN("\uD83D\uDFE9");

    private String icon;

    Color(String icon) {
        this.icon = icon;
    }


    public static Color mapped(final Word word, final char answer, final char input) {
        if (answer == input) {
            return Color.GREEN;
        }
        if (word.isContains(input)) {
            return Color.YELLOW;
        }
        return Color.GREY;
    }

    @Override
    public String toString() {
        return icon;
    }
}
