package wordle.app.word.domain;

enum MatchStatus {
    GREEN("🟩"),
    YELLOW("🟨"),
    GREY("⬜"),
    ;

    private final String output;

    MatchStatus(final String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return output;
    }
}
