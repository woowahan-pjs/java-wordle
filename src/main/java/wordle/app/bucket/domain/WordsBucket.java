package wordle.app.bucket.domain;

import wordle.app.word.domain.Answer;
import wordle.app.word.domain.Words;

import java.time.LocalDate;

public interface WordsBucket {

    Answer findAnswer(final LocalDate today);

    boolean contains(final Words words);

}
