package wordle.domain;

import java.util.Objects;
import wordle.exception.InvalidAlphabetException;

public class Alphabet {

    private static final char MIN_ALPHABET = 'a';
    private static final char MAX_ALPHABET = 'z';
    private final char alphabet;

    public Alphabet(final char alphabet) {
        final char lowerAlphabet = Character.toLowerCase(alphabet);
        if (lowerAlphabet < MIN_ALPHABET || lowerAlphabet > MAX_ALPHABET) {
            throw new InvalidAlphabetException();
        }

        this.alphabet = lowerAlphabet;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Alphabet alphabet1 = (Alphabet) o;
        return alphabet == alphabet1.alphabet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alphabet);
    }
}
