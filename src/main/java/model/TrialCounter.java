package model;

public class TrialCounter {
    private int trials = 0;
    private final int maxTrials;
    private boolean solved = false;

    public TrialCounter(int maxTrials) {
        this.maxTrials = maxTrials;
    }

    public static TrialCounter withTrials(final int trials) {
        TrialCounter counter = new TrialCounter(6);
        counter.trials = trials;
        return counter;
    }

    public void increment() {
        trials++;
    }

    public boolean keepTrying() {
        return !solved  && trials < maxTrials;
    }

    public int getTrials() {
        return trials;
    }

    public int getMaxTrials() {
        return maxTrials;
    }

    public void solveTheAnswer() {
        solved = true;
    }

    public boolean isSolved() {
        return solved;
    }
}
