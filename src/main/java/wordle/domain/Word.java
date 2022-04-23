package wordle.domain;

import org.assertj.core.util.VisibleForTesting;

import java.util.Objects;
import java.util.regex.Pattern;

class Word {

    private static final Pattern pattern = Pattern.compile("^[A-Za-z]+$");
    private final char value;
    private final Position position;

    Word(final char value, final int position) {
        if (!isAlphabet(value)) {
            throw new IllegalArgumentException("Input is not alphabetic: " + value);
        }

        this.value = Character.toLowerCase(value);
        this.position = new Position(position);
    }

    private boolean isAlphabet(final char value) {
        return pattern.matcher(String.valueOf(value)).matches();
    }

    @VisibleForTesting
    char getValue() {
        return value;
    }

    int getPosition() {
        return position.value;
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
