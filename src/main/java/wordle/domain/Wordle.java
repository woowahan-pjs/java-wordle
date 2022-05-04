package wordle.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Wordle {
    private final List<BingoHistory> histories = new ArrayList<>();
    private final List<String> targetWord = new ArrayList<>();
    private boolean status;
    private int executionCount;

    public Wordle(String targetWord) {
        if (targetWord == null || targetWord.isBlank())
        {
            throw new IllegalArgumentException("TargetWord는 필수입니다.");
        }
        this.targetWord.addAll(Arrays.asList(targetWord.split("")));
        this.status = true;
    }

    public boolean isContinue() {
        return status;
    }

    public void compare(String givenWord) {
        if (++executionCount == 6) {
            status = false;
        }

        BingoHistory history = new BingoHistory();
        // 정답
        List<String> convertedGivenWord = new ArrayList<>(Arrays.asList(givenWord.split("")));

        for (int i = 0; i < 5; i++) {
            BingoStatus bingoStatus = BingoStatus.NOTHING;
            if (targetWord.contains(convertedGivenWord.get(i)) && targetWord.get(i).equals(convertedGivenWord.get(i))) {
                bingoStatus = BingoStatus.MATCH;
            }

            if (targetWord.contains(convertedGivenWord.get(i)) && !targetWord.get(i).equals(convertedGivenWord.get(i))) {
                bingoStatus = BingoStatus.CONTAIN;
            }
            history.add(bingoStatus);
        }
        histories.add(history);
    }

    public List<BingoHistory> getHistory() {
        return Collections.unmodifiableList(histories);
    }
}
