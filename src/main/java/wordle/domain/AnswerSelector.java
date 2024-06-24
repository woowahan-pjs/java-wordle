package wordle.domain;


import java.util.List;

@FunctionalInterface
public interface AnswerSelector {
    Word select(final List<? extends Word> wordList);
}
