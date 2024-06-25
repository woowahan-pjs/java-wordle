package wordle.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameWord implements Word {
    private static final int MINIMUM_INDEX = 0;
    private static final int WORD_SIZE = 5;

    private final List<Alphabet> alphabets;

    private static List<Alphabet> alphabets(final String word) {
        return word.codePoints()
                .boxed()
                .map(Alphabet::of)
                .toList();
    }

    public GameWord(final String word) {
        this(alphabets(word));
    }

    public GameWord(final List<Alphabet> alphabets) {
        if (alphabets.size() != WORD_SIZE) {
            throw new IllegalArgumentException("단어는 5글자의 소문자 알파벳으로 이루어져야 합니다");
        }
        this.alphabets = alphabets;
    }

    public int size() {
        return alphabets.size();
    }

    public Alphabet find(final int index) {
        if (index < MINIMUM_INDEX || index >= alphabets.size()) {
            throw new IllegalArgumentException("단어의 길이보다 작거나 같은 인덱스만 들어올 수 있습니다");
        }
        return alphabets.get(index);
    }

    @Override
    public String word() {
        return alphabets.stream()
                .map(Enum::name)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final GameWord gameWord = (GameWord) o;
        return Objects.equals(alphabets, gameWord.alphabets);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(alphabets);
    }

}