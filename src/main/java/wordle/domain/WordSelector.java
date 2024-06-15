package wordle.domain;


import java.util.List;

public interface WordSelector {
    Word select(List<Word> wordList);
}
