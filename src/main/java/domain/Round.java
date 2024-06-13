package domain;

public class Round {
    private int limit;
    private int current;

    public Round(int limit, int current) {
        this.limit = limit;
        this.current = current;
    }

    void goNext() {
        this.current++;
    }

    Boolean isLastRound() {
        return this.current >= this.limit;
    }

    public int getLimit() {
        return limit;
    }

    public int getCurrent() {
        return current;
    }
}
