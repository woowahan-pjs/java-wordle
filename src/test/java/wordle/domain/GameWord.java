package wordle.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameWord implements Word {
    public static final int WORD_SIZE = 5;
    private List<Alphabet> alphabets;

    public GameWord(final List<Alphabet> alphabets) {
        validate(alphabets);
        this.alphabets = alphabets;
    }

    public GameWord(String word) {
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

    public Alphabet find(final int index) {
        return alphabets.get(index);
    }

    public List<Alphabet> alphabets() {
        return Collections.unmodifiableList(alphabets);
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
        GameWord gameWord = (GameWord) o;
        return Objects.equals(alphabets, gameWord.alphabets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alphabets);
    }
}
