package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Word {
    public static final int WORD_LENGTH = 5;

    private final List<Letter> word;

    public Word(String word) {
        validate(word);

        this.word = word.chars().mapToObj(c -> (char) c)
                        .map(Letter::new)
                        .collect(Collectors.toList());
    }

    public void validate(String word) {
        if (this.isNotMatchWord(word)) {
            throw new IllegalArgumentException(word + "는 5글자의 알파벳이 아닙니다.");
        }
    }

    private boolean isNotMatchWord(String word){
        return word.length() != WORD_LENGTH;
    }

    public List<Letter> getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word=" + word +
                '}';
    }
}
