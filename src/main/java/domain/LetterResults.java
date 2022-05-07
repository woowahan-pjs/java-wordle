package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LetterResults {
    private final List<LetterResult> letterResults;

    public List<LetterResult> getList() {
        return letterResults;
    }

    public void changeGreen(int index) {
        letterResults.set(index, LetterResult.GREEN);
    }

    public void changeYellow(int index) {
        letterResults.set(index, LetterResult.YELLOW);
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
        return new LetterResults(List.of(LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LetterResults that = (LetterResults) o;
        return Objects.equals(letterResults, that.letterResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letterResults);
    }

    @Override
    public String toString() {
        return letterResults.toString();
    }
}
