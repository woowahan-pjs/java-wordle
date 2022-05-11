package wordle.app.bucket.application.port.in;

import wordle.app.word.domain.Answer;

public interface FindAnswerPort {

    Answer findAnswer();

}
