package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoHistory {
    private final List<BingoStatus> bingoHistories;

    public BingoHistory(List<BingoStatus> bingoHistories) {
        this.bingoHistories = new ArrayList<>(bingoHistories);
    }

    public List<BingoStatus> getHistory() {
        return Collections.unmodifiableList(bingoHistories);
    }
}
