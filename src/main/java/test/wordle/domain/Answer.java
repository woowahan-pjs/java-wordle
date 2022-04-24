package test.wordle.domain;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private final Words answer;

    public Answer(final Words words) {
        this.answer = words;
    }

    public WordsMatchResult matches(final Words words) {
        final List<MatchStatus> matchesList = new ArrayList<>();
        for (final Word word : words.getWordList()) {
            matchesList.add(matches(word));
        }

        return new WordsMatchResult(matchesList);
    }

    private MatchStatus matches(final Word word) {
        if (notContains(word)) {
            return MatchStatus.GREY;
        }

        return hasGreen(word)
                ? MatchStatus.GREEN
                : MatchStatus.YELLOW;
    }

    private boolean hasGreen(final Word word) {
        final List<MatchStatus> matchesList = new ArrayList<>();
        for (final Word value : answer.getWordList()) {
            matchesList.add(word.matches(value));
        }

        return matchesList.contains(MatchStatus.GREEN);
    }

    private boolean notContains(final Word word) {
        return !answer.contains(word);
    }

}
