package test.wordle.domain;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private final List<Word> wordList;

    public Words(final String text) {
        wordList = new ArrayList<>();
        for (final char input : text.toCharArray()) {
            wordList.add(new Word(input));
        }
    }

    public int length() {
        return wordList.size();
    }
}
