package domain;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MatchResults implements Iterable<MatchResult> {
    private List<MatchResult> results;

    public MatchResults(List<MatchResult> results) {
        this.results = results;
    }

    @Override
    public Iterator<MatchResult> iterator() {
        return results.iterator();
    }

    public List<MatchResult> getResults() {
        return results;
    }
}
