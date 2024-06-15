package wordle.domain;

import java.util.List;

public class Guess {
    private final GameWord compositeWord;

    public Guess(GameWord word) {
        this.compositeWord = word;
    }

    public Guess(String word) {
        this(new GameWord(word));
    }

    public Guess(Word word) {
        this(new GameWord(word));
    }

    public int size() {
        return compositeWord.alphabets().size();
    }

    public List<Alphabet> subAlphabets(final int startIndex, final int endIndex) {
        return compositeWord.alphabets().subList(startIndex, endIndex);
    }

    public Alphabet find(final int index) {
        return compositeWord.find(index);
    }

    public long countAlphabets(final Alphabet alphabet, final int endIndex) {
        return compositeWord.countAlphabets(alphabet, endIndex);
    }
}
