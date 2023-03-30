package com.wodle.domain;

public enum TileColor {
    GREEN("\uD83D\uDFE9"),
    YELLOW("\uD83D\uDFE8"),
    GREY("⬜");

    private final String print;

    TileColor(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
