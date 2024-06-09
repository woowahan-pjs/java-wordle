package wordle.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Results implements Iterable<Result> {

    private final List<Result> results;
    public Results() {
        this.results = new ArrayList<>();
    }

    @Override
    public Iterator<Result> iterator() {
        return results.iterator();
    }

    public void add(Result result) {
        results.add(result);
    }
}
