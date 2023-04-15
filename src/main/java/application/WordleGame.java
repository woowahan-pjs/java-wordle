package application;

import domain.Colors;
import domain.Word;

public class WordleGame {

    private final Word answer;
    private int playRound;
    private boolean isEnd;

    public WordleGame(Word answer, int playRound) {
        this.answer = answer;
        this.playRound = playRound;
    }

    public Colors play(Word word) {
        playRound--;
        Colors colors = answer.compareWith(word);
        isEnd = colors.isAllGreen();
        return colors;
    }

    public boolean isEnd() {
        return playRound == 0 || isEnd;
    }
}
