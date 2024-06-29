package wordle;

import wordle.domain.*;
import wordle.view.InputView;
import wordle.view.OutputView;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final DictionaryReader dictionaryReader;
    private final WordSelector wordSelector;

    public Game(final InputView inputView,
                final OutputView outputView,
                final DictionaryReader dictionaryReader,
                final WordSelector wordSelector) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.dictionaryReader = dictionaryReader;
        this.wordSelector = wordSelector;
    }

    public void start() {
        final Dictionary dictionary = dictionaryReader.read();
        final Word word = dictionary.select(wordSelector);
        final Answer answer = new Answer(word.word());
        play(dictionary, answer);
    }

    private void play(final Dictionary dictionary, final Answer answer) {
        Attempt attempt = new Attempt();
        Results results = new Results();
        outputView.welcome(attempt.last());
        do {
            final Guess guess = guess(dictionary);
            final Result result = answer.examine(guess);
            results = results.add(result);
            attempt = attempt.next();
            outputView.showResults(results, attempt);
        } while (attempt.isRunning() && results.hasNotAnswer());
    }

    private Guess guess(final Dictionary dictionary) {
        try {
            outputView.insertWord();
            final String word = inputView.inputWord();
            if (dictionary.isExist(word)) {
                return new Guess(word);
            }
            throw new IllegalArgumentException();
        } catch (final Exception e) {
            outputView.wrongWord();
            return guess(dictionary);
        }
    }
}
