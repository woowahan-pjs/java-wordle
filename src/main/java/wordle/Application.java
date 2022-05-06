package wordle;

import wordle.ui.InputView;
import wordle.ui.ResultView;

public class Application {
    private static final int LIMIT_TRY_TO_BINGO = 6;

    public static void main(String[] args) {
        final WordleGameRunner wordleGameRunner =
            new WordleGameRunner(new InputView(), new ResultView(), LIMIT_TRY_TO_BINGO);

        wordleGameRunner.run();
    }
}
