package domain;

public class Round {
    private final int limit;
    private int current;

    private Round(int limit, int current) {
        this.limit = limit;
        this.current = current;
    }

    public Round(int limit) {
        this(limit, 1);
    }

    public void goNext() {
        this.current++;
    }

    public int getLimit() {
        return limit;
    }

    public int getCurrent() {
        return current;
    }

    public boolean isNotFinalRound() {
        return current <= limit;
    }
}
