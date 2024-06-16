package domain;

import java.util.Iterator;
import java.util.List;

public class MatchResult implements Iterable<Hint>{
    private final List<Hint> hints;

    public MatchResult(List<Hint> hints) {
        this.hints = hints;
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
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;
        return this.hints.equals(((MatchResult) obj).hints);
    }
}


