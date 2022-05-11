package wordle.app.word.domain;

import java.time.LocalDate;

public interface WordsBucket {

    Answer findAnswer(final LocalDate today);

    boolean contains(final Words words);

}
