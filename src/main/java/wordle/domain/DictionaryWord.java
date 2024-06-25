package wordle.domain;

import java.util.Objects;

public record DictionaryWord(String word) implements Word {

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DictionaryWord that = (DictionaryWord) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }
}
