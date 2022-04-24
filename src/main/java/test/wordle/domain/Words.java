package test.wordle.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Words words = (Words) o;
        return Objects.equals(wordList, words.wordList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordList);
    }
}
