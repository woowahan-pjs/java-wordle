package domain;

import java.util.Objects;

public class Wordle {

    private final char word;

    public Wordle(char word) {
        this.word = word;
    }

    public char getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wordle wordle = (Wordle) o;
        return word == wordle.word;
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
