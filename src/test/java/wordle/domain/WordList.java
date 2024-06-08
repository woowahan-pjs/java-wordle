package wordle.domain;

import java.util.List;

public class WordList {
    private List<Word> wordList;

    public WordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public boolean contains(Word word) {
        return wordList.contains(word);
    }

    public Word select(final Selector selector) {
        return selector.select(wordList);
    }
}
