package ui;

import domain.MatchResults;

import java.util.List;

public class HintView {
    public void render(List<MatchResults> matchResults) {
        matchResults.forEach(matchResultEachRound -> {
            matchResultEachRound.forEach(matchResult -> {
                System.out.print(matchResult.getTile());
            });
            System.out.println();
        });
    }
}
