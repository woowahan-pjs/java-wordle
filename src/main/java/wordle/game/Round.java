package wordle.game;

class Round {

    private static final int LAST_ROUND = 6;
    private int currentRound = 0;

    boolean isFinish() {
        return currentRound >= LAST_ROUND;
    }

    void start() {
        currentRound++;
    }

    @Override
    public String toString() {
        return currentRound + "/" + LAST_ROUND;
    }
}