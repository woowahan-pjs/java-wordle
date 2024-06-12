package wordle;

import wordle.domain.*;
import wordle.view.InputView;
import wordle.view.OutputView;

import java.util.ArrayList;

public class Game {
    private static final int MAX_ATTEMPT = 6;

    private final InputView inputView;
    private final OutputView outputView;
    private final WordListReader wordListReader;

    public Game(final InputView inputView,
                final OutputView outputView,
                final WordListReader wordListReader) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.wordListReader = wordListReader;
    }

    public void start(final Selector selector) {
        final WordList wordList = wordListReader.read();
        final Answer answer = new Answer(wordList.select(selector));
        outputView.welcome(MAX_ATTEMPT);
        Results results = new Results(new ArrayList<>(), MAX_ATTEMPT);
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





