package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoHistory {
    private final List<BingoStatus> statuses;

    public BingoHistory(List<BingoStatus> statuses) {
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

    public List<BingoStatus> getHistory() {
        return Collections.unmodifiableList(statuses);
    }
}
