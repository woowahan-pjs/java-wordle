package wordle.application;

import wordle.domain.Referee;
import wordle.domain.Tile;
import wordle.domain.WordBook;
import wordle.ui.InputAndOutput;
import wordle.util.DateCalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WordleGame {
    private static final LocalDate STANDARD_DATE = LocalDate.of(2021, 6, 19);
    private static final int MAX_ATTEMPTS = 6;
    private static final int WORD_LENGTH = 5;

    private final WordBook wordBook;
    private final InputAndOutput inputAndOutput;

    private Referee referee;
    private final List<Tile[]> history = new ArrayList<>();

    public WordleGame(final WordBook wordBook, final InputAndOutput inputAndOutput) {
        this.wordBook = wordBook;
        this.inputAndOutput = inputAndOutput;
    }

    public void startGame() {
        // 시작 전
        beforeGame();
        inputAndOutput.printWelcome();
        // 진행 중
        boolean isWin = playGame();
        // 결과
        endGame(isWin);
    }

    private void beforeGame() {
        long daysDiff = DateCalculator.calculate(STANDARD_DATE, LocalDate.now());

        int index = (int) (daysDiff % wordBook.getSize());

        String todayAnswer = wordBook.pick(index);
//        System.out.println("Today's Answer: " + todayAnswer);
        this.referee = new Referee(todayAnswer);
    }

    private boolean playGame() {
        while (history.size() < MAX_ATTEMPTS) {
            if (playRound()) {
                return true;
            }
        }
        return false;
    }

    private boolean playRound() {
        String guess = askAnswer();
        Tile[] result = referee.checkWordle(guess);

        history.add(result);
        inputAndOutput.printHistory(history);

        return isAllGreen(result);
    }

    private String askAnswer() {
        while (true) {
            String input = inputAndOutput.askAnswer().toLowerCase();

            if (isValid(input)) {
                return input;
            }
        }
    }

    private boolean isValid(final String input) {
        if (input.length() != WORD_LENGTH) {
            inputAndOutput.printInvalidInputMessage("단어는 5글자여야 합니다.");
            return false;
        }
        if (!input.matches("[a-zA-Z]+")) {
            inputAndOutput.printInvalidInputMessage("영문 알파벳만 입력 가능합니다.");
            return false;
        }
        return true;
    }

    private boolean isAllGreen(final Tile[] result) {
        for (Tile tile : result) {
            if (tile != Tile.GREEN) {
                return false;
            }
        }
        return true;
    }

    private void endGame(final boolean isWin) {
        if (isWin) {
            inputAndOutput.printAttemptCount(history.size(), MAX_ATTEMPTS);
            inputAndOutput.printHistory(history);
            return;
        }
        inputAndOutput.printEndFail();
    }
}
