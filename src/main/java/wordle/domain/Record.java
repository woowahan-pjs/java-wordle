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
        return existAllGreen() || isCountOver();
    }

    public boolean isCountOver() {
        return record.size() >= MAX_COUNT;
    }

    public boolean existAllGreen() {
        if (record.isEmpty()) {
            return false;
        }
        return record
                .getLast()
                .isAllGreen();
    }

    @Override
    public Iterator<Results> iterator() {
        return record.iterator();
    }

    public int size() {
        return record.size();
    }
}
