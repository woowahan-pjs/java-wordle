package wordle.domain;

public enum BingoColor {
    GREEN("일치", "\uD83D\uDFE9"),
    YELLOW("포함", "\uD83D\uDFE8"),
    GRAY("없음", "⬜");

    private String bingoStatus;
    public String printFormat;

    BingoColor(String bingoStatus, String printFormat) {
        this.bingoStatus = bingoStatus;
        this.printFormat = printFormat;
    }
}
