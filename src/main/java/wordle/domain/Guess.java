package wordle.domain;

public class Guess {
    private final GameWord word;

    public Guess(final GameWord word) {
        this.word = word;
    }

    public Guess(final String word) {
        this(new GameWord(word));
    }

    public Alphabet find(final int index) {
        return word.find(index);
    }
}
