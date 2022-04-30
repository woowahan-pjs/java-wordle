package model;

import static model.Result.*;

import java.util.List;

public class Results {

    private List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public Results() {
        this(List.of(NON_EXIST, NON_EXIST, NON_EXIST, NON_EXIST, NON_EXIST));
    }

    public boolean isMatch() {
        return results.stream()
                .allMatch(result -> result == MATCH);
    }

    public List<Result> getResults() {
        return results;
    }
}
