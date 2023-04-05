package wordle.domain.record;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRecords {
    private final List<GameRecord> records = new ArrayList<>();

    public void add(GameRecord gameRecord) {
        this.records.add(gameRecord);
    }

    public List<GameRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }
}
