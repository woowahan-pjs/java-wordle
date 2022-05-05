package domain;

import java.util.Objects;

public class Letter {
    private static final String VALIDATE_ALPHABET = "영문자만 가능합니다.";
    private final Character letter;

    public Letter(final Character letter) {
        if (!validateAlphabet(letter)) {
            throw new IllegalArgumentException(VALIDATE_ALPHABET);
        }
        this.letter = letter;
    }

    private boolean validateAlphabet(Character letter) {
        return (letter >= 0x61 && letter <= 0x7A) || (letter >= 0x41 && letter <= 0x5A);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter1 = (Letter) o;
        return Objects.equals(letter, letter1.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter);
    }
}
