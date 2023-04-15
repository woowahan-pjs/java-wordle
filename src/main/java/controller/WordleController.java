package controller;

import application.WordleGame;
import domain.Colors;
import domain.TryResult;
import domain.Word;
import domain.Words;
import java.time.LocalDate;
import ui.IOUtils;
import ui.InputView;
import ui.ResultView;

public class WordleController {

    public static final LocalDate START_DATE = LocalDate.of(2021, 6, 19);
    private static final int PLAY_ROUND = 6;

    public static void main(String[] args) {
        Words words = IOUtils.readFromResource("words.txt");

        ResultView.startComent();

        TryResult tryResult = new TryResult();
        WordleGame wordleGame = new WordleGame(words.answer(START_DATE, LocalDate.now()),
            PLAY_ROUND);

        while (!wordleGame.isEnd()) {
            Word word = words.getWord(InputView.inputComment());
            Colors play = wordleGame.play(word);
            tryResult.addTry(play);
            ResultView.results(tryResult);
        }
    }
}
