package wordle.domain;

import java.util.List;
import java.util.Objects;

public class Dictionary {
    private final List<DictionaryWord> words;

    public Dictionary(final List<DictionaryWord> words) {
        this.words = words;
    }

    public Word select(final WordSelector wordSelector) {
        return wordSelector.select(words);
    }

    public boolean isExist(final String word) {
        return words.stream().anyMatch(word::equals);
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
