package wordle.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Results implements Iterable<Result> {
    private final List<Result> results = new ArrayList<>();


    public void add(Result result) {
        results.add(result);
    }

    public boolean containsAnswer() {
        return results.getLast().isAnswer();
    }

    @Override
    public Iterator<Result> iterator() {
        return results.iterator();
    }

    public Stream<Result> stream() {
        return results.stream();
    }
}
