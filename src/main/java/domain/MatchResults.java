package domain;

import java.util.ArrayList;
import java.util.List;

public class MatchResults {
    private final List<MatchResult> matchResults;

    public MatchResults() {
        this.matchResults =new ArrayList<>();
    }

    public List<MatchResult> getMatchResults() {
        return matchResults;
    }
}
