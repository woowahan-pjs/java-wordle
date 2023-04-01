package wordle.domain;

import java.util.Objects;

public class Letter {
    private char ch;

    public Letter(char ch) {
        validateAlpha(ch);
        this.ch = ch;
    }

    public char getValue() {
        return ch;
    }

    private void validateAlpha(char ch) {
        // Letter 라는 클래스가 하나의 글자
        if (ch > 'z' || ch < 'a') {
            throw new IllegalArgumentException("shoud be alphabet");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return ch == letter.ch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch);
    }
}
