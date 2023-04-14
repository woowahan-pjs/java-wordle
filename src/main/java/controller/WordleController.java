package controller;

import domain.Colors;
import domain.TryResult;
import domain.Words;
import ui.IOUtils;
import ui.InputView;
import ui.ResultView;

public class WordleController {

    private static final int PLAY_ROUND = 6;
    private static final String WORDS_TXT = "words.txt";

    public static void main(String[] args) {
        Words words = Words.of(IOUtils.readFromResource(WORDS_TXT));

        ResultView.startComent();

        TryResult tryResult = new TryResult();
        int round = 0;
        while (round++ < PLAY_ROUND && !tryResult.isFinished()) {
            Colors colors = words.matchingAnswer(InputView.inputComment());
            tryResult.addTry(colors);
            ResultView.results(tryResult);
        }
    }
}
