package wordle.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultStorage {

    private final List<Result> storage = new ArrayList<>();

    public void add(Result result) {
        storage.add(result);
    }

    public List<Result> findAll() {
        return Collections.unmodifiableList(storage);
    }
}
