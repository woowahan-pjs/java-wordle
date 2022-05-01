package domain;

import java.util.List;

public class LetterResults {
    private List<LetterResult> letterResults;

    public List<LetterResult> getList() {
        return letterResults;
    }

    public LetterResults() {
        this.letterResults = List.of(LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN);
    }
}
