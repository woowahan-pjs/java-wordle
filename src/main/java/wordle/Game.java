package wordle;

import wordle.domain.*;
import wordle.view.InputView;
import wordle.view.OutputView;

public class Game {
    private static final int MAX_ATTEMPT = 6;

    private final InputView inputView;
    private final OutputView outputView;
    private final WordListReader wordListReader;
    private final AnswerSelector answerSelector;

    public Game(final InputView inputView,
                final OutputView outputView,
                final WordListReader wordListReader,
                final AnswerSelector answerSelector) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.wordListReader = wordListReader;
        this.answerSelector = answerSelector;
    }

    public void start() {
        final WordList wordList = wordListReader.read();
        final Answer answer = new Answer(wordList.select(answerSelector));
        play(wordList, answer);
    }

    private void play(final WordList wordList, final Answer answer) {
        Attempt attempt = new Attempt(MAX_ATTEMPT);
        Results results = new Results();
        outputView.welcome(attempt.last());
        do {
            attempt = attempt.next();
            results = results.add(examine(wordList, answer));
            outputView.showResults(results, attempt);
        } while (attempt.isRunning() && results.hasNotAnswer());
    }

    private Result examine(final WordList wordList, final Answer answer) {
        final Guess guess = inputWord(wordList);
        return answer.examine(guess);
    }

    private Guess inputWord(final WordList wordList) {
        try {
            outputView.insertWord();
            final String guess = inputView.inputWord();
            return new Guess(wordList.getWord(guess));
        } catch (final Exception e) {
            outputView.wrongWord();
            return inputWord(wordList);
        }
    }
}
