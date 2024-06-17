package wordle.domain;

import java.util.List;
import java.util.Objects;

public class Word {
    private static final int FROM_INDEX = 0;
    private static final int WORD_SIZE = 5;
    private final List<Alphabet> alphabets;

    public Word(final List<Alphabet> alphabets) {
        validate(alphabets);
        this.alphabets = alphabets;
    }

    public Word(final String word) {
        this(word.chars()
                .mapToObj(it -> (char) it)
                .map(Alphabet::of)
                .toList());
    }

    private static void validate(final List<Alphabet> alphabets) {
        if (alphabets.size() != WORD_SIZE) {
            throw new IllegalArgumentException("단어는 5글자의 소문자 알파벳으로 이루어져야 합니다");
        }
    }

    public int size() {
        return alphabets.size();
    }

    public Alphabet find(final int index) {
        return alphabets.get(index);
    }

    public long countAlphabets(final Alphabet alphabet, final int toIndex) {
        if (toIndex > alphabets.size()) {
            throw new IllegalArgumentException("단어의 길이보다 작거나 같은 인덱스만 들어올 수 있습니다");
        }
        return alphabets.subList(FROM_INDEX, toIndex)
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
