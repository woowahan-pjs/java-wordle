package test.wordle.domain;

import java.util.Objects;

public class Word {

    private final char value;

    public Word(final char value) {
        if (!Character.isAlphabetic(value)) {
            throw new IllegalArgumentException("Input is not alphabetic: " + value);
        }

        this.value = Character.toLowerCase(value);
    }

    public char getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Word word = (Word) o;
        return value == word.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
