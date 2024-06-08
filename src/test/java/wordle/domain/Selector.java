package wordle.domain;

import java.util.List;

@FunctionalInterface
public interface Selector {
    Word select(List<Word> wordList);
}
