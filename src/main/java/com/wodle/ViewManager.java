package com.wodle;

import com.wodle.domain.TileColor;
import java.util.LinkedList;
import java.util.List;

public class ViewManager {

    private List<List<TileColor>> wordMatchResults;

    public ViewManager() {
        wordMatchResults = new LinkedList<>();
    }

    public void printResult(Result woreCompareResult) {
        wordMatchResults.add(woreCompareResult.getMatchStatus());

        for (List<TileColor> wordMatchResult : wordMatchResults) {
            print(wordMatchResult);
            System.out.println();
        }
    }

    private void print(List<TileColor> curWordMatchResult) {
        for (TileColor tileColor : curWordMatchResult) {
            System.out.print(tileColor.name() + " ");
        }
    }
}
