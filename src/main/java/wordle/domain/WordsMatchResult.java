package wordle.domain;

import java.util.List;

public class WordsMatchResult {

    private final List<MatchStatus> matchStatusList;

    public List<MatchStatus> getMatchStatusList() {
        return matchStatusList;
    }

    public WordsMatchResult(final List<MatchStatus> matchesList) {
        this.matchStatusList = matchesList;
    }

    public boolean isCorrect() {
        return !containsGreyOrYellow();
    }

    private boolean containsGreyOrYellow() {
        return matchStatusList.contains(MatchStatus.YELLOW) || matchStatusList.contains(MatchStatus.GREY);
    }

}
