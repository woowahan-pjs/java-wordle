package wordle.app.word.application.port;

import wordle.app.word.domain.Answer;
import wordle.app.word.domain.MatchResult;
import wordle.app.word.domain.Words;

public interface MatchWordsPort {

    MatchResult matches(final Answer answer, final Words inputWords);

}
