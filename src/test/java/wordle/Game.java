package wordle;

import wordle.domain.*;
import wordle.view.InputView;
import wordle.view.OutputView;

import java.util.ArrayList;
import java.util.stream.IntStream;

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

    public void start(final WordSelector wordSelector) {
        final WordList wordList = wordListReader.read();
        final Answer answer = new Answer(wordList.select(wordSelector));
        outputView.welcome(MAX_ATTEMPT);
        execute(wordList, answer);
    }

    private void execute(final WordList wordList, final Answer answer) {
        Results results = new Results(new ArrayList<>());
        IntStream.range(0, MAX_ATTEMPT)
                .boxed()
                .takeWhile(attempt -> !results.hasAnswer())
                .forEach(attempt -> examine(wordList, answer, attempt, results));
    }

    private void examine(final WordList wordList, final Answer answer, final Integer attempt, final Results results) {
        final Guess guess = inputWord(wordList);
        final Result result = answer.examineResult(guess);
        results.add(result);
        outputView.showResults(results, attempt, MAX_ATTEMPT);
    }

    private Guess inputWord(WordList wordList) {
        try {
            outputView.insertWord();
            final Word word = inputView.inputWord();
            return new Guess(wordList.find(word));
        } catch (final Exception e) {
            outputView.wrongWord();
            return inputWord(wordList);
        }
    }
}





