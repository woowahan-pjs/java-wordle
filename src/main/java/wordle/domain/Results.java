package wordle.domain;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Results implements Iterable<Result> {

    private final SortedSet<Result> results;

    public Results() {
        this.results = new TreeSet<>();
    }

    @Override
    public Iterator<Result> iterator() {
        return results.iterator();
    }

    public void add(Result result) {
        results.add(result);
    }

    public boolean isCheckedPosition(Position position) {
        return results.stream()
                .anyMatch(result -> result.isSamePosition(position));
    }

    public boolean isAnswer() {
        return results.stream().allMatch(Result::isGreen);
    }
}
