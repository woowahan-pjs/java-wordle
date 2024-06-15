package wordle.domain;


public interface GameWordSelector {
    GameWord select(WordList wordList);
}
