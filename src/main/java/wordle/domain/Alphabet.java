package wordle.domain;

import java.util.Objects;
import wordle.exception.InvalidAlphabetException;

public class Alphabet {

    private final char alphabet;

    public Alphabet(char alphabet) {
        char lowerAlphabet = Character.toLowerCase(alphabet);
        if (lowerAlphabet < 'a' || lowerAlphabet > 'z') {
            throw new InvalidAlphabetException();
        }

        this.alphabet = lowerAlphabet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Alphabet alphabet1 = (Alphabet) o;
        return alphabet == alphabet1.alphabet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alphabet);
    }
}
