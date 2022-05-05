package game;

public class Round {
    private static final int MAX_ROUND = 6;
    private int currentRound = 0;

    public boolean isFinish() {
        return currentRound >= MAX_ROUND;
    }

    public void nextRound() {
        currentRound++;
    }

    @Override
    public String toString() {
        return currentRound +" / "+MAX_ROUND;
    }
}
