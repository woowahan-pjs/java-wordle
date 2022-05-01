package wordle.domain;

import java.util.ArrayList;
import java.util.List;

public class WordsMatchResults {

    private final List<WordsMatchResult> matchResultList;

    public WordsMatchResults() {
        this.matchResultList = new ArrayList<>();
    }

    public void add(final WordsMatchResult result) {
        matchResultList.add(result);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final WordsMatchResult result : matchResultList) {
            stringBuilder.append(result).append("\n");
        }
        return stringBuilder.toString();
    }
}
