package wordle.domain;

public enum BingoStatus {
    MATCH("\uD83D\uDFE9"),
    CONTAIN("\uD83D\uDFE8"),
    NOTHING("⬜");

    public final String printFormat;

    BingoStatus(String printFormat) {
        this.printFormat = printFormat;
    }

    public Boolean isMatch() {
        return this == MATCH;
    }
}
