package wordle;

import wordle.domain.Word;
import wordle.domain.WordFile;
import wordle.domain.WordleGame;
import wordle.ui.InputView;
import wordle.ui.ResultView;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class WordleGameRunner {
    private final int limitTryToBingo;
    private final InputView inputView;
    private final ResultView resultView;
    private final WordleGame wordleGame;

    public WordleGameRunner(InputView inputView, ResultView resultView, int limitTryToBingo) {
        try {
            this.inputView = inputView;
            this.resultView = resultView;
            this.limitTryToBingo = limitTryToBingo;
            this.wordleGame = new WordleGame(new Word(scanGoalWord()));
        } catch (FileNotFoundException notFoundEx) {
            throw new IllegalArgumentException("파일을 찾을 수 없어 게임을 종료합니다.");
        }
    }

    private String scanGoalWord() throws FileNotFoundException {
        return new WordFile("words.txt").findGoalWord(LocalDate.now());
    }

    public void run() {
        printGameStart();

        compareToMatchGivenTimes();
    }

    private void printGameStart() {
        resultView.printGameStart();
    }

    private void compareToMatchGivenTimes() {
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
            } catch (IllegalArgumentException illegalArgEx) {
                resultView.printInputErrorMessage(illegalArgEx.getMessage());
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
