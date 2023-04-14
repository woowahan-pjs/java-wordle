package domain;

import java.util.ArrayList;
import java.util.List;

public class TryResult {
    private List<Colors> results = new ArrayList<>();
    private boolean finished;

    public void addTry(Colors colors) {
        if (colors.isAllGreen()) {
            finished = true;
        }
        results.add(colors);
    }

    public int count() {
        return results.size();
    }

    public List<Colors> getResults() {
        return results;
    }

    public boolean isFinished() {
        return finished;
    }
}
