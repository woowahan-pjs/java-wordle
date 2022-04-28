package wordle.domain;

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

        return isGreen(word)
                ? MatchStatus.GREEN
                : MatchStatus.YELLOW;
    }

    private boolean isGreen(final Word word) {
        return word.equals(answer.getWordList().get(word.getPosition()));
    }

    private boolean notContains(final Word word) {
        return !answer.contains(word);
    }

}
