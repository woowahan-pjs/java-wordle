package wordle.domain;

public class Attempt {
    private static final int START_INDEX = 0;
    private static final int INCREASE_UNIT = 1;

    private final int current;
    private final int last;

    public Attempt(final int maxAttempt) {
        this(START_INDEX, maxAttempt);
    }

    public Attempt(final int current, final int maxAttempt) {
        this.current = current;
        this.last = maxAttempt;
    }

    public int current() {
        return current;
    }

    public int last() {
        return last;
    }

    public boolean isRunning() {
        return current < last;
    }

    public Attempt next() {
        return new Attempt(Math.addExact(current, INCREASE_UNIT), last);
    }
}
