package wordle.view;

import wordle.domain.Results;

public interface OutputView {
    void welcome();

    void insertWord();

    void wrongWord();

    void showResults(Results results, final int maxAttempt);

    void insertedWord(String wordString);
}