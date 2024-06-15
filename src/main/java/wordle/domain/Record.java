package wordle.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class Record {

    public static final int MAX_COUNT = 6;
    private final List<Results> record;

    public Record() {
        this.record = new ArrayList<>();
    }

    public void add(Results results) {
        record.add(results);
    }

    public boolean isEnd() {
        return existAllGreen() || record.size() >= MAX_COUNT;
    }

    private boolean existAllGreen() {
        if (record.isEmpty()) {
            return false;
        }
        return record
                .getLast()
                .isAllGreen();
    }
}
