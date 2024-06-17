package wordle.domain;

public class Guess {
    private final Word word;

    public Guess(final Word word) {
        this.word = word;
    }

    public Guess(final String word) {
        this(new Word(word));
    }

    public int size() {
        return word.size();
    }

    public Alphabet find(final int index) {
        return word.find(index);
    }

    public long countAlphabets(final Alphabet alphabet, final int endIndex) {
        return word.countAlphabets(alphabet, endIndex);
    }
}
