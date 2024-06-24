package wordle.domain;

public class Attempt {
    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 6;
    private static final int NEXT_UNIT = 1;

    private final int current;
    private final int last;

    public Attempt() {
        this(MINIMUM, MAXIMUM);
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
        return new Attempt(Math.addExact(current, NEXT_UNIT), last);
    }
}
