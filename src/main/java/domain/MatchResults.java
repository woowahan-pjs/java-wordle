package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MatchResults implements Iterable<MatchResult> {
    private final Round round = new Round();
    private final List<MatchResult> results;

    public MatchResults() {
        this.results = new ArrayList<>();
    }

    @Override
    public Iterator<MatchResult> iterator() {
        return this.results.iterator();
    }

    public void add(MatchResult matchResult) {
        results.add(matchResult);
        round.goNext();
    }

    public boolean shouldContinueGame() {
        return round.isNotFinalRound() && isNotWinning();
    }

    public int currentRound() {
        return round.getCurrent();
    }

    public boolean isWinning() {
        return this.results.stream().anyMatch(MatchResult::isWinning);
    }

    public boolean isNotWinning() {
        return !isWinning();
    }
}
