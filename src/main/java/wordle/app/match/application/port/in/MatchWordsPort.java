package wordle.app.match.application.port.in;

import wordle.app.word.domain.Answer;
import wordle.app.match.domain.MatchResult;
import wordle.app.word.domain.Words;

public interface MatchWordsPort {

    MatchResult matches(final Answer answer, final Words inputWords);

}
