package domain;

import java.util.List;
import java.util.Objects;

public class MatchResults {
    private List<MatchResult> results;

    public MatchResults(List<MatchResult> results) {
        this.results = results;
    }

    public List<MatchResult> getResults() {
        return results;
    }
}