package wordle.app.bucket.application.port.in;

import wordle.app.word.domain.Words;

public interface ContainWordsPort {

    boolean contains(final Words words);

}
