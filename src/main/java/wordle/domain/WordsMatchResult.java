package wordle.domain;

import java.util.List;

public class WordsMatchResult {

    private static final List<MatchStatus> GREEN_ONLY = List.of(MatchStatus.GREEN);
    private final List<MatchStatus> matchStatusList;

    public List<MatchStatus> getMatchStatusList() {
        return matchStatusList;
    }

    public WordsMatchResult(final List<MatchStatus> matchesList) {
        this.matchStatusList = matchesList;
    }

    public boolean isCorrect() {
        return !containsGreenOnly();
    }

    private boolean containsGreenOnly() {
        return GREEN_ONLY.containsAll(matchStatusList);
    }

}
