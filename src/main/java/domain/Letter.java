package domain;

import java.util.Objects;

public class Letter {
    private final String letter;

    public Letter(Character letter) {
        if (this.isNotAlphabet(letter)) {
            throw new IllegalArgumentException(letter + "는 알파벳이 아닙니다.");
        }

        this.letter = String.valueOf(letter);
    }

    private boolean isNotAlphabet(Character letter) {
        return !(letter >= 'A' && letter <= 'Z') && !(letter >= 'a' && letter <= 'z');
    }

    public String getLetter() {
        return letter;
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

    @Override
    public String toString() {
        return "Letter{" +
                "letter='" + letter + '\'' +
                '}';
    }
}
