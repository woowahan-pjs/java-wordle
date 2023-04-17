package domain;

public class Letter {

    private final Character letter;

    public Letter(char letter) {
        if (isNotAlphabet(letter)) {
            throw new IllegalArgumentException("문자는 영문자만 가능합니다.");
        }
        this.letter = letter;
    }

    private static boolean isNotAlphabet(char letter) {
        return !((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z'));
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

    public Character getLetter() {
        return letter;
    }
}
