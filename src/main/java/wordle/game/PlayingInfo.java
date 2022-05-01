package wordle.game;

import wordle.domain.Answer;
import wordle.domain.Words;
import wordle.domain.WordsMatchResult;
import wordle.domain.WordsMatchResults;

class PlayingInfo {

    private WordsMatchResults wordsMatchResults;
    private Answer answer;
    private Round round;
    private Words inputWords;
    private boolean isCorrect;

    void init(final Answer answer) {
        round = new Round();
        wordsMatchResults = new WordsMatchResults();
        this.answer = answer;
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

    boolean matches() {
        final WordsMatchResult result = answer.matches(inputWords);
        addMatchResults(result);
        return result.isCorrect();
    }
}