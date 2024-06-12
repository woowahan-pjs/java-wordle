package wordle.domain;

import java.util.Objects;

public class Word {
    public static final int WORD_SIZE = 5;

    private String word;

    public Word(String word) {
        validate(word);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    private static void validate(final String word) {
        if (word.trim().length() != WORD_SIZE) {
            throw new RuntimeException();
        }
        boolean result = word.chars()
                .mapToObj(c -> (char) c)
                .allMatch(c -> c >= 'a' && c <= 'z');

        if (!result) {
            throw new RuntimeException();
        }
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

    public boolean isSameWord(final String word) {
        return this.word.equals(word);
    }
}
