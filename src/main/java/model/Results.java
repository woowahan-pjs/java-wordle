package model;

import java.util.List;

public class Results {

    private List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public boolean isMatch() {
        return results.stream()
                .allMatch(result -> result == Result.MATCH);
    }
}
