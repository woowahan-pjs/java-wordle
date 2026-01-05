package wordle.app.word.application.port.in;

import wordle.app.word.domain.Words;

public interface ContainWordsPort {

    boolean contains(final Words words);

}
