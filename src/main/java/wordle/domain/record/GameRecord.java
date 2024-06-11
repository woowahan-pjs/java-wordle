package wordle.domain.record;

import wordle.domain.Result;

import java.util.Collections;
import java.util.List;

public class GameRecord {
    private final List<Result> results;

    public GameRecord(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

}
