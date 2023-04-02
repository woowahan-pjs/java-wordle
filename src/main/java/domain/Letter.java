package domain;

public class Letter {

    private final char letter;
    private final int position;

    public Letter(char letter, int position) {
        if (isNotAlphabet(letter)) {
            throw new IllegalArgumentException("문자는 영문자만 가능합니다.");
        }
        this.letter = letter;
        this.position = position;
    }

    private static boolean isNotAlphabet(char letter) {
        return !((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z'));
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Letter letter1 = (Letter) o;

        return letter == letter1.letter;
    }

    @Override
    public int hashCode() {
        return letter;
    }
}
