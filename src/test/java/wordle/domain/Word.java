package wordle.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Word {
    public static final int WORD_SIZE = 5;

    private List<Alphabet> alphabets;

    public Word(final List<Alphabet> alphabets) {
        validate(alphabets);
        this.alphabets = alphabets;
    }

    public Word(String word) {
        this(word.chars()
                .mapToObj(it -> (char) it)
                .map(Alphabet::of)
                .toList());
    }

    public List<Alphabet> alphabets() {
        return Collections.unmodifiableList(alphabets);
    }

    private static void validate(final List<Alphabet> alphabets) {
        if (alphabets.size() != WORD_SIZE) {
            throw new RuntimeException();
        }
    }

    public boolean isSameWord(final String word) {
        return this.equals(new Word(word));
    }

    public Alphabet find(final int index) {
        return alphabets.get(index);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Word word = (Word) o;
        return Objects.equals(alphabets, word.alphabets);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(alphabets);
    }
}
