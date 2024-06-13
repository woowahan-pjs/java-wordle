package wordle.domain;


public interface Selector {
    Word select(WordList wordList);
}
