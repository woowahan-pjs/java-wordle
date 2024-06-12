package wordle.domain;

import java.util.Collections;
import java.util.List;

public class Results {
    private List<Result> results;
    private boolean isFinished = false;

    public Results(List<Result> results) {
        this.results = results;
    }

    private boolean allMatched() {
        return results.stream().anyMatch(Result::allMatched);
    }

    public void add(Result result) {
        results.add(result);
        if (allMatched() || results.size() == 6) {
            isFinished = true;
        }
    }

    public boolean isFinished() {
        return isFinished;
    }

    public int size() {
        return results.size();
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
