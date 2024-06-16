package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MatchResults implements Iterable<MatchResult> {
    private final List<MatchResult> results;

    public MatchResults() {
        this.results = new ArrayList<>();
    }

    @Override
    public Iterator<MatchResult> iterator() {
        return this.results.iterator();
    }

    public void add(MatchResult matchResultOfInput) {
        this.results.add(matchResultOfInput);
    }
}
