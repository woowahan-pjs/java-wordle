package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Results {
    private final List<Result> results;

    public Results() {
        this(new ArrayList<>());
    }

    public Results(final List<Result> results) {
        this.results = results;
    }

    public boolean hasNotAnswer() {
        return !(hasAnswer());
    }

    public boolean hasAnswer() {
        return results.stream().anyMatch(Result::allMatched);
    }

    public Results add(final Result result) {
        results.add(result);
        return new Results(results);
    }

    public int size() {
        return results.size();
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Results results1 = (Results) o;
        return Objects.equals(getResults(), results1.getResults());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getResults());
    }
}
