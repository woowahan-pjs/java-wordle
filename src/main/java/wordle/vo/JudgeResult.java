package wordle.vo;

public enum JudgeResult {
    GOOD(true),
    BAD(false);

    private final boolean endAble;

    JudgeResult(boolean endAble) {
        this.endAble = endAble;
    }

    public boolean isEndAble() {
        return endAble;
    }
}
