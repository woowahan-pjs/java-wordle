package application;

import domain.Colors;
import domain.Word;

public class WordleGame {

    private final Word answer;
    private final TryResult result;
    private int playRound;

    public WordleGame(Word answer, int playRound) {
        this.answer = answer;
        this.result = new TryResult();
        this.playRound = playRound;
    }

    public TryResult play(Word word) {
        Colors colors = answer.compareWith(word);
        playRound--;
        result.addTry(colors);
        return result;
    }

    public boolean isEnd() {
        return playRound == 0 || result.isFinished();
    }
}
