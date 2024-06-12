package wordle.domain;

import java.util.Collections;
import java.util.List;

public class Results {
    private List<Result> results;
    private int maxAttempt;

    public Results(List<Result> results, final int maxAttempt) {
        this.results = results;
        this.maxAttempt = maxAttempt;
    }

    private boolean allMatched() {
        return results.stream().anyMatch(Result::allMatched);
    }

    public void add(Result result) {
        results.add(result);
    }

    public boolean isFinished(int attempt) {
        return (allMatched() || attempt == maxAttempt);
    }

    public int size() {
        return results.size();
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
