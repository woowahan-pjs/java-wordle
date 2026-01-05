package wordle;

import wordle.domain.*;
import wordle.view.InputView;
import wordle.view.OutputView;

import java.util.stream.IntStream;

public class Game {
    private static final int START_ATTEMPT = 0;
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
        final Results results = new Results();
        IntStream.range(START_ATTEMPT, MAX_ATTEMPT)
                .boxed()
                .takeWhile(attempt -> !results.hasAnswer())
                .forEach(attempt -> {
                    results.add(examine(wordList, answer));
                    outputView.showResults(results, attempt, MAX_ATTEMPT);
                });
    }

    private Result examine(final WordList wordList, final Answer answer) {
        final Guess guess = inputWord(wordList);
        return answer.examineResult(guess);
    }

    private Guess inputWord(final WordList wordList) {
        try {
            outputView.insertWord();
            final Word word = inputView.inputWord();
            return new Guess(wordList.getWordIfExists(word));
        } catch (final Exception e) {
            outputView.wrongWord();
            return inputWord(wordList);
        }
    }
}
