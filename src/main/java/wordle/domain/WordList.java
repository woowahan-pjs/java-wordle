package wordle.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class WordList {
    private final List<Word> wordList;

    public WordList(final List<Word> wordList) {
        this.wordList = wordList;
    }

    public Word select(final AnswerSelector answerSelector) {
        return answerSelector.select(wordList);
    }

    public Word getWord(final String word) {
        return wordList.stream()
                .filter(it -> it.isSameAs(word))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
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
