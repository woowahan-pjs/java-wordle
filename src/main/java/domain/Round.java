package domain;

public class Round {
    public final static int ROUND_LIMIT = 3;
    private final int limit;
    private int current;

    public Round() {
        limit = ROUND_LIMIT;
        current = 1;
    }

    public void goNext() {
        this.current++;
    }

    public int getCurrent() {
        return current;
    }

    public boolean isNotFinalRound() {
        return current <= limit;
    }
}
