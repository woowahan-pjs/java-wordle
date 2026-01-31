package wordle.domain;

public class Letter {

    private final char alphabet; // a ~ z

    public Letter(final char alphabet) {
        this.alphabet = alphabet;
    }

    public char getAlphabet() {
        return alphabet;
    }
}
