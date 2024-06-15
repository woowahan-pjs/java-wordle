package wordle.domain;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class WordList {
    private List<DictionaryWord> wordList;

    public WordList(List<DictionaryWord> wordList) {
        this.wordList = wordList;
    }

    public WordList(final String... words) {
        this(Arrays.stream(words)
                .map(DictionaryWord::new)
                .toList());
    }

    public GameWord select(final GameWordSelector gameWordSelector) {
        return gameWordSelector.select(this);
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
