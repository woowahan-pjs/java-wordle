package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MatchResult implements Iterable<Hint>{
    private final List<Hint> hints;

    public MatchResult(List<Hint> hints) {
        this.hints = hints;
    }

    public MatchResult() {
        this.hints = new ArrayList<>();
    }

    @Override
    public Iterator<Hint> iterator() {
        return hints.iterator();
    }

    public boolean isEndGame() {
        return hints.stream().allMatch(Hint::isCorrect);
    }

    public void add(Hint hint) {
        hints.add(hint);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hints.equals(((MatchResult) obj).hints);
    }
}


