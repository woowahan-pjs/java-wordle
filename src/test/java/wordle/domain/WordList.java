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

    public Word select(final WordSelector wordSelector) {
        return wordSelector.select(wordList);
    }

    public Word find(final String word) {
        return wordList.stream()
                .filter(it -> it.equals(word))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public int size() {
        return wordList.size();
    }

    public Word get(final long index) {
        return get((int) index);
    }

    public Word get(final int index) {
        if (wordList.isEmpty()) {
            throw new RuntimeException();
        }
        return wordList.get(index);
    }
}
