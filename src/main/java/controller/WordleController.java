package controller;

import domain.Color;
import domain.TryResult;
import domain.Word;
import domain.Words;
import ui.IOUtils;
import ui.InputView;
import ui.ResultView;

import java.time.LocalDate;
import java.util.List;

public class WordleController {

    private static final int PLAY_ROUND = 6;
    private static final String WORDS_TXT = "words.txt";

    public static void main(String[] args) {
        Words words = new Words(IOUtils.readFromResource(WORDS_TXT));

        ResultView.startComent();

        TryResult tryResult = new TryResult();
        int round = 0;
        while (round++ < PLAY_ROUND && !tryResult.isFinished()) {
            List<Color> colors = words.matchingAnswer(InputView.inputComment());
            tryResult.addTry(colors);
            ResultView.results(tryResult);
        }
    }
}
