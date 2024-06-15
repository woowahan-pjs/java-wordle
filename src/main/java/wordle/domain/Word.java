package wordle.domain;

import java.util.List;
import java.util.Objects;

public class Word {
    public static final int WORD_SIZE = 5;
    private List<Alphabet> alphabets;

    public Word(List<Alphabet> alphabets) {
        validate(alphabets);
        this.alphabets = alphabets;
    }

    public Word(String word) {
        this(word.chars()
                .mapToObj(it -> (char) it)
                .map(Alphabet::of)
                .toList());
    }

    private static void validate(final List<Alphabet> alphabets) {
        if (alphabets.size() != WORD_SIZE) {
            throw new RuntimeException();
        }
    }

    public int size() {
        return alphabets.size();
    }

    public Alphabet find(final int index) {
        return alphabets.get(index);
    }

    public long countAlphabets(final Alphabet alphabet, final int endIndex) {
        return alphabets.subList(0, endIndex)
                .stream()
                .filter(it -> it.equals(alphabet))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(alphabets, word.alphabets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alphabets);
    }
}
