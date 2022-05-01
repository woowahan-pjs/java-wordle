package domain;

import java.util.List;

public class LetterResults {
    private final List<LetterResult> letterResults;

    public List<LetterResult> getList() {
        return letterResults;
    }

    public LetterResults(List<LetterResult> letterResults) {
        this.letterResults = letterResults;
    }
    public static LetterResults correctAll() {
        return new LetterResults(List.of(LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN));
    }
}
