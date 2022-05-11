package model;

public enum Result {

    MATCH("🟩"), EXIST("🟨"), NON_EXIST("⬜");

    private final String resultMark;

    Result(String resultMark) {
        this.resultMark = resultMark;
    }

    public String getResultMark() {
        return resultMark;
    }
}
