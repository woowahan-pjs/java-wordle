package model;

import static model.Result.MATCH;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public boolean isMatch() {
        return results.stream()
                .allMatch(result -> result == MATCH);
    }

    public List<Result> convertToList() {
        return results;
    }
}
