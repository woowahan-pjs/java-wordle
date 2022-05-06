package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BingoRecord that = (BingoRecord) o;
        return isAllMatch() == that.isAllMatch() && Objects.equals(statuses, that.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statuses, isAllMatch());
    }
}
