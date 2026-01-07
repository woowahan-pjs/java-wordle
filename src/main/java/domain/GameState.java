package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameState implements Iterable<MatchResult> {
    private final Round round = new Round();
    private final List<MatchResult> matchResults;

    public GameState() {
        this.matchResults = new ArrayList<>();
    }

    @Override
    public Iterator<MatchResult> iterator() {
        return matchResults.iterator();
    }

    public void add(MatchResult matchResult) {
        matchResults.add(matchResult);
        round.goNext();
    }

    public boolean shouldContinueGame() {
        return round.isNotFinalRound() && isNotWinning();
    }

    public int currentRound() {
        return round.getCurrent();
    }

    public boolean isWinning() {
        return matchResults.stream().anyMatch(MatchResult::isWinning);
    }

    public boolean isNotWinning() {
        return !isWinning();
    }
}
