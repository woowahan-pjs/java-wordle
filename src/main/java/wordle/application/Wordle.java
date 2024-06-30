package wordle.application;

import wordle.domain.AnswerFormula;
import wordle.domain.BaseAnswerFormula;
import wordle.domain.Record;
import wordle.domain.Results;
import wordle.domain.Word;
import wordle.domain.WordBook;
import wordle.exception.WordNotExistException;
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

    public Wordle(WordBook wordBook, InputView inputView, OutputView outputView) {
        this.wordBook = wordBook;
        this.inputView = inputView;
        this.outputView = outputView;
        this.record = new Record();
        this.answerFormula = new BaseAnswerFormula();
    }

    public void startGame() {
        Word answerWord = wordBook.pick(answerFormula);
        outputView.welcome();
        runGame(answerWord);
        concludeGame();
    }

    private void runGame(Word answerWord) {
        while (!record.isEnd()) {
            outputView.showRecord(record);
            handleWrongAnswer(() -> processTurn(answerWord));
        }
    }

    private void processTurn(Word answerWord) {
        outputView.askAnswer();
        Word inputWord = wordBook.find(inputView.input())
                .orElseThrow(() -> new WordNotExistException(inputView.input()));
        Results results = answerWord.compare(inputWord);
        record.add(results);
    }

    private void concludeGame() {
        if (record.existAnswer()) {
            outputView.successEnd(record);
            return;
        }
        outputView.failEnd(record);
    }

    private void handleWrongAnswer(Runnable runnable) {
        try {
            runnable.run();
        } catch (WordleInvalidInputException e) {
            outputView.wrongAnswer();
        } catch (WordleException e) {
            outputView.unexpectedEnd();
        }
    }
}
