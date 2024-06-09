package wordle.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class Results implements Iterable<Result> {

    private final Result[] results;

    public Results(Result[] results) {
        this.results = results;
    }

    @Override
    public Iterator<Result> iterator() {
        return Arrays.stream(results).iterator();
    }
}
