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
        for (Result result : results) {
            if (result.isSamePosition(position)) {
                return true;
            }
        }

        return false;
    }

    public boolean isAllGreen() {
        return results.stream().allMatch(Result::isGreen);
    }
}
