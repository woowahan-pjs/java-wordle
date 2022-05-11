package wordle.app.word.domain;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private final Words answer;

    public Answer(final Words words) {
        this.answer = words;
    }

    public MatchResult matches(final Words words) {
        final List<MatchStatus> matchesList = matchWords(words);

        return new MatchResult(matchesList);
    }

    private List<MatchStatus> matchWords(final Words words) {
        final List<MatchStatus> matchesList = new ArrayList<>();
        for (final Word word : words.getWordList()) {
            matchesList.add(matchWord(word));
        }
        return matchesList;
    }

    private MatchStatus matchWord(final Word word) {
        if (notContains(word)) {
            return MatchStatus.GREY;
        }

        if (isSameWordInPosition(word)) {
            return MatchStatus.GREEN;
        }

        return MatchStatus.YELLOW;
    }

    private boolean isSameWordInPosition(final Word word) {
        return word.equals(answer.get(word.getPosition()));
    }

    private boolean notContains(final Word word) {
        return !answer.contains(word);
    }

}
