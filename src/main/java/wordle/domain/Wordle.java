package wordle.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Wordle {
    private static final int MAX_TRY_COUNT = 6;
    private final List<BingoHistory> histories = new ArrayList<>();
    private final List<String> targetWord = new ArrayList<>();
    private final String targetWordString;
    private boolean status;
    private int executionCount;

    public Wordle(String targetWord) {
        if (targetWord == null || targetWord.isBlank()) {
            throw new IllegalArgumentException("TargetWord는 필수입니다.");
        }
        this.targetWordString = targetWord;
        this.targetWord.addAll(Arrays.asList(targetWord.split("")));
        this.status = true;
    }

    public boolean isContinue() {
        return status;
    }

    public void compare(String givenWord) {
        if (++executionCount == MAX_TRY_COUNT || targetWordString.equals(givenWord)) {
            status = false;
        }

        BingoHistory history = new BingoHistory();

        List<String> convertedGivenWord = new ArrayList<>(Arrays.asList(givenWord.split("")));

        for (int i = 0; i < 5; i++) {
            BingoStatus bingoStatus = BingoStatus.NOTHING;
            String givnWordCharacter = convertedGivenWord.get(i);
            if (targetWord.contains(givnWordCharacter) && targetWord.get(i).equals(givnWordCharacter)) {
                bingoStatus = BingoStatus.MATCH;
            }

            if (targetWord.contains(givnWordCharacter) && !targetWord.get(i)
                    .equals(givnWordCharacter)) {
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
