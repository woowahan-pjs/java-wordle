package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoRecord {
    private final List<BingoStatus> statuses;

    public BingoRecord(List<BingoStatus> statuses) {
        this.statuses = new ArrayList<>(statuses);
    }

    public boolean isAllMatch() {
        for (BingoStatus bs : statuses) {
            if (bs.isMatch()) {
                continue;
            }
            return false;
        }

        return true;
    }

    public List<BingoStatus> getRecord() {
        return Collections.unmodifiableList(statuses);
    }
}
