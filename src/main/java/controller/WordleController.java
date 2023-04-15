package controller;

import application.WordleGame;
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
        ResultView.startComent();
        Words words = IOUtils.readFromResource("words.txt");
        play(words);
    }

    private static void play(final Words words) {
        Word answer = words.answer(START_DATE, LocalDate.now());
        WordleGame wordleGame = new WordleGame(answer, PLAY_ROUND);

        while (!wordleGame.isEnd()) {
            Word word = words.getWord(InputView.inputComment());
            ResultView.results(wordleGame.play(word));
        }
    }
}
