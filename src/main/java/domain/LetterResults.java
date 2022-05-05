package domain;

import java.util.Arrays;
import java.util.List;

public class LetterResults {
    private static final List<LetterResult> ALL_GREEN_LIST = List.of(LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN);
    private final List<LetterResult> letterResults;

    public List<LetterResult> getList() {
        return letterResults;
    }

    public int size() {
        return letterResults.size();
    }

    public void changeGreen(int index) {
        letterResults.set(index, LetterResult.GREEN);
    }

    public void changeYellow(int index) {
        letterResults.set(index, LetterResult.YELLOW);
    }

    public boolean isAllGreen() {
        return letterResults.equals(ALL_GREEN_LIST);
    }

    public LetterResults() {
        letterResults = Arrays.asList(
                LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY
        );
    }

    public LetterResults(List<LetterResult> letterResults) {
        this.letterResults = letterResults;
    }

    public static LetterResults correctAll() {
        return new LetterResults(ALL_GREEN_LIST);
    }
}
