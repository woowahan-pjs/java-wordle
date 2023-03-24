package woowaapplication.pair.game.wordle;

public enum WordleBlock {
    CORRECT("GREEN"),
    EXIST_BUT_WRONG_SPOT("YELLOW"),
    WRONG("GRAY"),
    ;

    private String color;

    WordleBlock(String color) {
        this.color = color;
    }
}
