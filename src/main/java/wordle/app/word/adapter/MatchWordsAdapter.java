package wordle.app.word.adapter;

import wordle.app.word.application.port.MatchWordsPort;
import wordle.app.word.domain.MatchResult;

public class MatchWordsAdapter {

    private final MatchWordsPort matchWordsPort;

    public MatchWordsAdapter(final MatchWordsPort matchWordsPort) {
        this.matchWordsPort = matchWordsPort;
    }

    public MatchResult matches(final MatchWordsRequest request) {
        if (request != null) {
            return matchWordsPort.matches(request.getAnswer(), request.getWords());
        }

        throw new IllegalArgumentException("MatchWordsRequest is null");
    }

}
