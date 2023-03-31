package wordle;

public class Word {
    private char ch;

    public Word(char ch) {
        validateAlpha(ch);
        this.ch = ch;
    }

    private void validateAlpha(char ch) {
        // Word 라는 클래스가 하나의 글자
        if (ch > 'z' || ch <'a') {
            throw new IllegalArgumentException("shoud be alphabet");
        }
    }
}
