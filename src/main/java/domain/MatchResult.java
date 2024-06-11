package domain;

public class MatchResult {
    private char inputChar;
    private Hint hint;

    public MatchResult(char inputChar, Hint hint) {
        this.inputChar = inputChar;
        this.hint = hint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchResult that = (MatchResult) o;

        if (inputChar != that.inputChar) return false;
        return hint == that.hint;
    }

    @Override
    public int hashCode() {
        int result = inputChar;
        result = 31 * result + (hint != null ? hint.hashCode() : 0);
        return result;
    }
}


