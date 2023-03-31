package wordle;

public class Round {

    private static final int MAX_STAGE = 6;
    private int current = 0;

    public void next() {
        this.current += 1;
    }

    public boolean isFinal() {
        return this.current >= MAX_STAGE;
    }
}
