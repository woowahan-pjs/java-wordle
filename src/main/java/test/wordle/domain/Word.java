package test.wordle.domain;

public class Word {
    
    private final char value;
    
    public Word(final char value) {
        if (!Character.isAlphabetic(value)) {
            throw new IllegalArgumentException("Input is not alphabetic: " + value);
        }

        this.value = Character.toLowerCase(value);
    }

    public char getValue() {
        return value;
    }
}
