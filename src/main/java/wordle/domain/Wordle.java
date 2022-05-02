package wordle.domain;

import java.util.ArrayList;
import java.util.List;

public class Wordle {
    private final List<BingoHistory> history = new ArrayList<>();
    private final String targetWord;
    private boolean status;

    public Wordle(String targetWord) {
        if (targetWord == null || targetWord.isBlank())
        {
            throw new IllegalArgumentException("TargetWord는 필수입니다.");
        }
        this.targetWord = targetWord;
        this.status = true;
    }

    public boolean isContinue() {
        return status;
    }
}
