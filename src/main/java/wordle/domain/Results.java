package wordle.domain;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = results;
    }

    public boolean hasAnswer() {
        return results.stream().anyMatch(Result::allMatched);
    }

    public void add(final Result result) {
        results.add(result);
    }

    public int size() {
        return results.size();
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
