package wordle.domain;

import java.util.List;
import java.util.Objects;

public class DictionaryWord implements Word {
    private final List<Alphabet> alphabets;

    public DictionaryWord(final String alphabets) {
        this(alphabets.chars()
                .mapToObj(it -> (char) it)
                .map(Alphabet::of)
                .toList()
        );
    }

    public DictionaryWord(final List<Alphabet> alphabets) {
        this.alphabets = alphabets;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DictionaryWord that = (DictionaryWord) o;
        return Objects.equals(alphabets, that.alphabets);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(alphabets);
    }
}
