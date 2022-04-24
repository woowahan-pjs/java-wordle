package wordle.domain;

import java.util.Objects;

public class Word {

    private final char value;
    private final Position position;

    public Word(final char value, final int position) {
        if (!Character.isAlphabetic(value)) {
            throw new IllegalArgumentException("Input is not alphabetic: " + value);
        }

        this.value = Character.toLowerCase(value);
        this.position = new Position(position);
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

    public MatchStatus matches(final Word word) {
        if (this.value != word.value) {
            return MatchStatus.GREY;
        }

        if (this.position.equals(word.position)) {
            return MatchStatus.GREEN;
        }

        return MatchStatus.YELLOW;
    }

    private static class Position {

        private final int value;

        public Position(final int value) {
            this.value = value;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Position position = (Position) o;
            return value == position.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

}
