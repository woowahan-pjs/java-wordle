package wordle;

import wordle.domain.*;
import wordle.view.InputView;
import wordle.view.OutputView;

import java.time.LocalDate;
import java.util.ArrayList;

public class Game {
    private static final int MAX_ATTEMPT = 6;

    private InputView inputView;
    private OutputView outputView;
    private WordListReader wordListReader;

    public Game(InputView inputView, OutputView outputView, WordListReader wordListReader) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.wordListReader = wordListReader;
    }

    public void start() {
        // todo 게임 시작
        final WordList wordList = wordListReader.read();
        final Answer answer = new Answer(wordList.select(new TimeBaseAnswerSelector(LocalDate.now())));
        outputView.welcome();
        Results results = new Results(new ArrayList<>());
        for (int i = 0; i < MAX_ATTEMPT; i++) {
            final Guess guess = inputWord(wordList);
            final Result result = answer.examineResult(guess);
            results.add(result);
            outputView.showResults(results, MAX_ATTEMPT);
            if (results.isFinished()) {
                break;
            }
        }
    }

    private Guess inputWord(WordList wordList) {
        try {
            outputView.insertWord();
            final String wordString = inputView.inputWord();
            Guess guess = new Guess(wordList.find(wordString));
            outputView.insertedWord(wordString);
            return guess;
        } catch (final Exception e) {
            outputView.wrongWord();
            return inputWord(wordList);
        }
    }
}





