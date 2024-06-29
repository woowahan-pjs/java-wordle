package wordle.view;

import wordle.domain.Attempt;
import wordle.domain.Results;

public interface OutputView {
    void welcome(final int maxAttempt);

    void insertWord();

    void wrongWord();

    void showResults(final Results results, final Attempt attempt);
}
