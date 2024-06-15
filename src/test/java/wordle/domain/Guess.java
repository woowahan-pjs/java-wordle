package wordle.domain;

import java.util.List;

public class Guess extends Word {

    public Guess(String word) {
        super(word);
    }

    public Guess(Word word) {
        super(word.alphabets());
    }

    public List<Alphabet> subAlphabets(final int startIndex, final int endIndex) {
        return alphabets().subList(startIndex, endIndex);
    }
}
