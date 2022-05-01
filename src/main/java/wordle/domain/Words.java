package wordle.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Words {

    private static final int WORDS_LENGTH = 5;
    private final List<Word> wordList;

    public Words(final String text) {
        if (text.length() != WORDS_LENGTH) {
            throw new IllegalArgumentException("length of the word must be 5");
        }

        wordList = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            wordList.add(new Word(text.charAt(i),i));
        }
    }

    List<Word> getWordList() {
        return Collections.unmodifiableList(wordList);
    }

    boolean contains(final Word word) {
        return wordList.contains(word);
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

    Word get(final int position) {
        return wordList.get(position);
    }
}
