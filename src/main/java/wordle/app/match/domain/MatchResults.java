package wordle.app.match.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchResults {

    private final List<MatchResult> matchResultList;

    public MatchResults() {
        this.matchResultList = new ArrayList<>();
    }

    public void add(final MatchResult result) {
        matchResultList.add(result);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final MatchResult result : matchResultList) {
            stringBuilder.append(result).append("\n");
        }
        return stringBuilder.toString();
    }
}
