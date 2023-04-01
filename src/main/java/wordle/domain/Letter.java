package wordle.domain;

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
}
