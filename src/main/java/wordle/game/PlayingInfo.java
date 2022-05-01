package wordle.game;

import wordle.domain.Words;
import wordle.domain.WordsMatchResult;
import wordle.domain.WordsMatchResults;

class PlayingInfo {
    private WordsMatchResults wordsMatchResults;
    private Round round;
    private Words inputWords;
    private boolean isCorrect;

    void init() {
        round = new Round();
        wordsMatchResults = new WordsMatchResults();
    }

    void play() {
        round.start();
    }

    void updateStatus(final boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    boolean isFinish() {
        return round.isFinish() || isCorrect;
    }

    WordsMatchResults getCurrentMatchResults() {
        return wordsMatchResults;
    }

    void addMatchResults(final WordsMatchResult result) {
        wordsMatchResults.add(result);
    }

    void updateCurrentWords(final Words words) {
        this.inputWords = words;
    }

    Words getCurrentWords() {
        return inputWords;
    }

    Round getCurrentRound() {
        return round;
    }

    boolean isCorrect() {
        return isCorrect;
    }

}