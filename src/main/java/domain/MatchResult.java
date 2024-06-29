package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MatchResult {
    private final List<HintLetter> hints;
    public MatchResult(List<HintLetter> hints) {
        this.hints = hints;
    }

    public boolean isEndGame() {
        return hints.stream()
                .allMatch(HintLetter::isCorrectHint);
    }
    public void add(HintLetter hintLetter) {
        hints.add(hintLetter);
    }

    public String getHintTiles() {
        return hints.stream()
                .map(HintLetter::getHintTile)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return Objects.equals(hints, that.hints);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hints);
    }
}


