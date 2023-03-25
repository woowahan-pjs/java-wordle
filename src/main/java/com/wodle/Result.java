package com.wodle;

import java.util.List;

public class Result {

    private final int matchCount;
    private final List<Integer> matchStatus;

    public Result(List<Integer> matchStatus) {
        this.matchStatus = matchStatus;
        this.matchCount = matchStatus.stream()
            .map((status) -> status / 2)
            .mapToInt(Integer::intValue)
            .sum();
    }

    public boolean isGameEnd() {
        return matchCount == matchStatus.size();
    }
}
