package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public List<String> toPrintFormat() {
        return statuses.stream()
            .map(status -> status.printFormat)
            .collect(toList());
    }

    public List<BingoStatus> getRecord() {
        return Collections.unmodifiableList(statuses);
    }
}
