package test.wordle.domain;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private final List<Word> wordList;

    public Words(final String text) {
        if (text.length() != 5) {
            throw new IllegalArgumentException("length of the word must be 5");
        }
        wordList = new ArrayList<>();
        for (final char input : text.toCharArray()) {
            wordList.add(new Word(input));
        }
    }

    public int length() {
        return wordList.size();
    }
}
