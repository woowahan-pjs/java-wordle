package wordle.domain;

public class Guess extends Word {
    public Guess(String word) {
        super(word);
    }

    public Guess(Word word) {
        this(word.getWord());
    }
}
