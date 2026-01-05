package wordle.domain;

public class Round {

    private static final int MAX_ROUND = 6;
    private int current = 1;

    public void next() {
        this.current += 1;
    }

    public boolean isFinal() {
        return this.current >= MAX_ROUND;
    }

    @Override
    public String toString() {
        return current + "/" + MAX_ROUND;
    }
}
