package controller;

import application.WordleGame;
import domain.Colors;
import domain.TryResult;
import domain.Words;
import ui.IOUtils;
import ui.InputView;
import ui.ResultView;

public class WordleController {

    private static final int PLAY_ROUND = 6;

    public static void main(String[] args) {
        Words words = new Words(IOUtils.readFromResource("words.txt"));

        ResultView.startComent();

        TryResult tryResult = new TryResult();
        WordleGame wordleGame = new WordleGame(words, PLAY_ROUND);

        while (!wordleGame.isEnd()) {
            Colors play = wordleGame.play(InputView.inputComment());
            tryResult.addTry(play);
            ResultView.results(tryResult);
        }
    }
}
