package wordle.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Dictionary {
    private final List<? extends Word> words;

    public Dictionary(final List<? extends Word> words) {
        this.words = words;
    }

    public Answer answer(final AnswerSelector answerSelector) {
        final Word word = answerSelector.select(words);
        return new Answer(word.word());
    }

    public Guess guess(final String word) {
        return words.stream()
                .filter(it -> it.isSameAs(word))
                .findFirst()
                .map(Word::word)
                .map(Guess::new)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Dictionary dictionary1 = (Dictionary) o;
        return Objects.equals(words, dictionary1.words);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(words);
    }
}
