package application;

import domain.Colors;
import domain.Word;
import domain.Words;

public class WordleGame {

    private final Words words;
    private int playRound;
    private boolean isEnd;

    public WordleGame(Words words, int playRound) {
        this.words = words;
        this.playRound = playRound;
    }

    public Colors play(Word word) {
        playRound--;
        Colors colors = words.matchingAnswer(word);
        isEnd = colors.isAllGreen();
        return colors;
    }

    public boolean isEnd() {
        return playRound == 0 || isEnd;
    }
}
