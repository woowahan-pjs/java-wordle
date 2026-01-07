package ui;

import domain.MatchResult;
import domain.MatchResults;

public class HintView {
    public void render(MatchResults matchResults) {
        matchResults.forEach(HintView::drawTiles);
    }

    private static void drawTiles(MatchResult matchResultEachRound) {
        System.out.print(matchResultEachRound.getHintTiles());
        System.out.println();
    }
}
