package model;

public class TrialCounter {
    private int trials = 0;
    private boolean gameOver = false;

    public void increment() {
        trials++;
    }

    public boolean keepTrying() {
        return trials < 6 && !gameOver;
    }

    public int getTrials() {
        return trials;
    }

    public void gameOver() {
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
