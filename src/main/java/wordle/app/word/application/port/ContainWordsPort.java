package wordle.app.word.application.port;

import wordle.app.word.domain.Words;

public interface ContainWordsPort {

    boolean contains(final Words words);

}
