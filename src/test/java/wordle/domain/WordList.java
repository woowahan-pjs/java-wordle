package wordle.domain;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class WordList {
    private List<Word> wordList;

    public WordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public WordList(final String... words) {
        this(Arrays.stream(words)
                .map(Word::new)
                .toList());
    }

    public boolean contains(Word word) {
        return wordList.contains(word);
    }

    public Word select(final Selector selector) {
        return selector.select(this);
    }

    public Word find(final String word) {
        return wordList.stream()
                .filter(it -> it.isSameWord(word))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public boolean isEmpty() {
        return wordList.isEmpty();
    }

    public int size() {
        return wordList.size();
    }

    public Word get(final long index) {
        if (wordList.isEmpty()) {
            throw new RuntimeException();
        }
        return get((int) index);
    }

    public Word get(final int index) {
        return wordList.get(index);
    }
}
