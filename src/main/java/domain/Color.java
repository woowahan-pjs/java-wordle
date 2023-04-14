package domain;

public enum Color {
    GREY ("⬜"),
    YELLOW ("\uD83D\uDFE8"),
    GREEN ("\uD83D\uDFE9");

    private String icon;

    Color(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return icon;
    }
}
