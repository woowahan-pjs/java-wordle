package wordle.app.word.adapter;

import wordle.app.word.domain.Answer;
import wordle.app.word.domain.MatchResult;
import wordle.app.word.domain.Words;
import wordle.app.word.application.port.MatchWordsPort;

public class MatchWordsAdapter {

    private final MatchWordsPort matchWordsPort;

    public MatchWordsAdapter(final MatchWordsPort matchWordsPort) {
        this.matchWordsPort = matchWordsPort;
    }

    public MatchResult matches(final Answer answer, final Words words) {
        return matchWordsPort.matches(answer, words);
    }

}
