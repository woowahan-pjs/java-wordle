package application;

import domain.Colors;
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
        Colors colors = getLastColor();
        return colors.isAllGreen();
    }

    private Colors getLastColor() {
        if (results.size() == 0) {
            return Colors.EMPTY;
        }
        return results.get(results.size() - 1);
    }
}
