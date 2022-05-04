package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoHistory {
    private static final int LIMIT_SIZE = 5;
    private final List<BingoStatus> histories = new ArrayList<>();

    public void add(BingoStatus bs) {
        if (histories.size() == LIMIT_SIZE) {
            throw new IllegalArgumentException("정답 유무 기록은 최대 " + LIMIT_SIZE + "까지 추가할 수 있습니다.");
        }

        histories.add(bs);
    }

    public List<BingoStatus> getHistory() {
        return Collections.unmodifiableList(histories);
    }
}
