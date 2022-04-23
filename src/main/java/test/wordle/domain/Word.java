package test.wordle.domain;

public class Word {
    
    private final char value;
    
    public Word(final char value) {
        this.value = Character.toLowerCase(value);
    }

    public char getValue() {
        return value;
    }
}
