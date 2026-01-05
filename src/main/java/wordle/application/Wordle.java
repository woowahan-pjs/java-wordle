package wordle.application;

import wordle.domain.AnswerFormula;
import wordle.domain.BaseAnswerFormula;
import wordle.domain.Record;
import wordle.domain.Results;
import wordle.domain.Word;
import wordle.domain.WordBook;
import wordle.exception.WordleException;
import wordle.exception.WordleInvalidInputException;
import wordle.ui.InputView;
import wordle.ui.OutputView;

public class Wordle {

    private final WordBook wordBook;

    private final InputView inputView;

    private final OutputView outputView;

    private final Record record;

    private final AnswerFormula answerFormula;

    public Wordle(final WordBook wordBook, final InputView inputView, final OutputView outputView) {
        this.wordBook = wordBook;
        this.inputView = inputView;
        this.outputView = outputView;
        this.record = new Record();
        this.answerFormula = new BaseAnswerFormula();
    }

    public void startGame() {
        final Word answerWord = wordBook.pick(answerFormula);
        outputView.welcome();
        runGame(answerWord);
        concludeGame();
    }

    private void runGame(final Word answerWord) {
        while (!record.isEnd()) {
            outputView.showRecord(record);
            handleWrongAnswer(() -> process(answerWord));
        }
    }

    private void process(final Word answerWord) {
        outputView.askAnswer();
        final Word inputWord = wordBook.find(inputView.input());
        final Results results = answerWord.compare(inputWord);
        record.add(results);
    }

    private void concludeGame() {
        if (record.existAllGreen()) {
            outputView.successEnd(record);
            return;
        }
        outputView.failEnd(record);
    }

    private void handleWrongAnswer(final Runnable runnable) {
        try {
            runnable.run();
        } catch (final WordleInvalidInputException e) {
            outputView.wrongAnswer();
        } catch (final WordleException e) {
            outputView.unexpectedEnd();
        }
    }
}
