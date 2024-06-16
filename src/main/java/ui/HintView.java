package ui;

import domain.MatchResult;
import domain.MatchResults;

public class HintView {
    public void render(MatchResults matchResults) {
        matchResults.forEach(matchResultEachRound -> {
            renderTiles(matchResultEachRound);
            System.out.println();
        });
    }

    private void renderTiles(MatchResult matchResultEachRound) {
        matchResultEachRound.forEach(matchResult -> {
            System.out.print(matchResult.getTile());
        });
    }
}
