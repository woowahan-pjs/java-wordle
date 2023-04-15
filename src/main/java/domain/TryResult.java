package domain;

import java.util.ArrayList;
import java.util.List;

public class TryResult {

    private List<Colors> results = new ArrayList<>();

    public void addTry(Colors colors) {
        results.add(colors);
    }

    public int count() {
        return results.size();
    }

    public List<Colors> getResults() {
        return results;
    }

    public boolean isFinished() {
        Colors colors = results.get(results.size() - 1);
        return colors.isAllGreen();
    }
}
