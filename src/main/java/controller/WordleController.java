package controller;

import domain.WordleGames;
import util.AnswerExtractor;

import static view.output.OutputView.printMain;

public class WordleController {
    private final String FILE_NAME = "words.txt";

    public void start() {
        printMain();

        String answer = AnswerExtractor.extractAnswer(FILE_NAME);

        WordleGames wordleGames = new WordleGames();
        wordleGames.start(answer);
    }


}
