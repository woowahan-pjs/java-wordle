package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoRecord {
    private final List<BingoStatus> statuses;
    private final boolean isAllMatch;

    public BingoRecord(List<BingoStatus> statuses) {
        this.statuses = new ArrayList<>(statuses);
        this.isAllMatch = isAllMatch(statuses);
    }

    private boolean isAllMatch(List<BingoStatus> statuses) {
        for (BingoStatus bs : statuses) {
            if (bs.isMatch()) {
                continue;
            }
            return false;
        }

        return true;
    }

    public boolean isAllMatch() {
        return isAllMatch;
    }

    public List<BingoStatus> getRecord() {
        return Collections.unmodifiableList(statuses);
    }
}
