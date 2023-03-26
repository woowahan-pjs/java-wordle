package com.wodle;

import com.wodle.domain.TileColor;
import java.util.Collections;
import java.util.List;

public class Result {

    private final long matchCount;
    private final List<TileColor> matchStatus;

    public Result(List<TileColor> matchStatus) {
        this.matchStatus = matchStatus;
        this.matchCount = matchStatus.stream()
            .filter(tileColor -> tileColor == TileColor.GREEN)
            .count();
    }

    public boolean isGameEnd() {
        return matchCount == matchStatus.size();
    }

    public List<TileColor> getMatchStatus(){ return Collections.unmodifiableList(matchStatus) ;}
}
