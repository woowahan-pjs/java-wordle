package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordleGame {
    private final Word goalWord;
    private final List<BingoRecord> bingoRecords = new ArrayList<>();
    private boolean isAllMatch = false;

    public WordleGame(Word goalWord) {
        this.goalWord = goalWord;
    }

    public void compareToMatch(Word givenWord) {
        final BingoRecord resultRecord = new BingoRecord(goalWord.compare(givenWord));
        bingoRecords.add(resultRecord);

        if (resultRecord.isAllMatch()) {
            isAllMatch = true;
        }
    }

    public boolean isAllMatch() {
        return isAllMatch;
    }

    public List<BingoRecord> getBingoRecords() {
        return Collections.unmodifiableList(bingoRecords);
    }
}
