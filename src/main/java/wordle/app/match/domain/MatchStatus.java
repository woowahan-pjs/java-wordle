package wordle.app.match.domain;

public enum MatchStatus {
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
