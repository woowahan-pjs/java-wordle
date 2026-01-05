package wordle.app.word.application.port.out;

import wordle.app.word.domain.Answer;
import wordle.app.word.domain.Words;

import java.time.LocalDate;

public interface WordsBucketPort {

    Answer findAnswer(final LocalDate today);

    boolean contains(final Words words);

}
