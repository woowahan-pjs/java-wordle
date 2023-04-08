package domain;

import java.util.ArrayList;
import java.util.List;

public class TryResult {
    private static final List<Color> ALL_GREEN = List.of(Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);
    private List<List<Color>> results = new ArrayList<>();
    private boolean finished;

    public void addTry (List<Color> colors) {
        if (colors.equals(ALL_GREEN)) {
            finished = true;
        }
        results.add(colors);
    }

    public int count() {
        return results.size();
    }
    public List<List<Color>> getResults() {
        return results;
    }

    public boolean isFinished() {
        return finished;
    }
}
