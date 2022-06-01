package wordle;

import wordle.domain.Word;
import wordle.domain.WordFile;
import wordle.domain.WordleGame;
import wordle.ui.InputView;
import wordle.ui.ResultView;

import java.time.LocalDate;

public class WordleGameRunner {
    private final int limitTryToBingo;
    private final InputView inputView;
    private final ResultView resultView;
    private final WordleGame wordleGame;

    public WordleGameRunner(InputView inputView, ResultView resultView, int limitTryToBingo) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.limitTryToBingo = limitTryToBingo;
        this.wordleGame = new WordleGame(new Word(scanGoalWord()));
    }

    private String scanGoalWord() {
        return new WordFile("words.txt").findGoalWord(LocalDate.now());
    }

    public void run() {
        printGameStart();

        compareToMatch(wordleGame);
    }

    private void printGameStart() {
        resultView.printGameStart();
    }

    private void compareToMatch(WordleGame wordleGame) {
        for (int i = 1; i <= limitTryToBingo; i++) {
            final Word usersWord = inputUsersWord();

            wordleGame.compareToMatch(usersWord);

            printBingoRecords(i);

            if (wordleGame.isAllMatch()) {
                break;
            }
        }
    }

    private Word inputUsersWord() {
        do {
            resultView.printInputWord();

            try {
                final String givenWord = inputView.inputUsersWord();
                resultView.printEmptyLine();

                return new Word(givenWord);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            resultView.printRetryInputWord();
        } while (true);
    }

    private void printBingoRecords(int turn) {
        if (wordleGame.isAllMatch()) {
            resultView.printTurnAndLimitTryToBingo(turn, limitTryToBingo);
        }

        resultView.printBingoRecords(wordleGame.getBingoRecords());
    }
}
