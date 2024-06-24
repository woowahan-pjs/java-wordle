package wordle;

import wordle.domain.*;
import wordle.view.InputView;
import wordle.view.OutputView;

public class Game {
    private static final int MAX_ATTEMPT = 6;

    private final InputView inputView;
    private final OutputView outputView;
    private final DictionaryReader dictionaryReader;
    private final AnswerSelector answerSelector;

    public Game(final InputView inputView,
                final OutputView outputView,
                final DictionaryReader dictionaryReader,
                final AnswerSelector answerSelector) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.dictionaryReader = dictionaryReader;
        this.answerSelector = answerSelector;
    }

    public void start() {
        final Dictionary dictionary = dictionaryReader.read();
        final Answer answer = dictionary.answer(answerSelector);
        play(dictionary, answer);
    }

    private void play(final Dictionary dictionary, final Answer answer) {
        Attempt attempt = new Attempt(MAX_ATTEMPT);
        Results results = new Results();
        outputView.welcome(attempt.last());
        do {
            attempt = attempt.next();
            results = results.add(examine(dictionary, answer));
            outputView.showResults(results, attempt);
        } while (attempt.isRunning() && results.hasNotAnswer());
    }

    private Result examine(final Dictionary dictionary, final Answer answer) {
        final Guess guess = guess(dictionary);
        return answer.examine(guess);
    }

    private Guess guess(final Dictionary dictionary) {
        try {
            outputView.insertWord();
            final String word = inputView.inputWord();
            return dictionary.guess(word);
        } catch (final Exception e) {
            outputView.wrongWord();
            return guess(dictionary);
        }
    }
}
