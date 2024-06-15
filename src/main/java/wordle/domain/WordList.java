package wordle.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class WordList {
    private final List<Word> wordList;

    public WordList(final List<Word> wordList) {
        this.wordList = wordList;
    }

    public Word select(final WordSelector wordSelector) {
        return wordSelector.select(wordList);
    }

    public Word find(final Word word) {
        return wordList.stream()
                .filter(it -> it.equals(word))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public int size() {
        return wordList.size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WordList wordList1 = (WordList) o;
        return Objects.equals(wordList, wordList1.wordList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(wordList);
    }
}
