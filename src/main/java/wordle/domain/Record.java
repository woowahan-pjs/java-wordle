package wordle.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Record implements Iterable<Results> {

    public static final int MAX_COUNT = 6;
    private final List<Results> record;

    public Record() {
        this.record = new ArrayList<>();
    }

    public void add(Results results) {
        record.add(results);
    }

    public boolean isEnd() {
        return existAnswer() || isCountOver();
    }

    public boolean isCountOver() {
        return record.size() >= MAX_COUNT;
    }

    public boolean existAnswer() {
        if (record.isEmpty()) {
            return false;
        }

        return record
                .getLast()
                .isAnswer();
    }

    @Override
    public Iterator<Results> iterator() {
        return record.iterator();
    }

    public int size() {
        return record.size();
    }
}
