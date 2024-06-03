package wordle.app.match.application.service;

import wordle.app.match.application.port.in.MatchWordsPort;
import wordle.app.match.domain.MatchResult;
import wordle.app.word.domain.Answer;
import wordle.app.word.domain.Words;

public class MatchService implements MatchWordsPort {

    @Override
    public MatchResult matches(final Answer answer, final Words words) {
        return answer.matches(words);
    }

}
