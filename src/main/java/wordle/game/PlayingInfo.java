package wordle.game;

import wordle.domain.Answer;
import wordle.domain.Words;
import wordle.domain.WordsMatchResult;
import wordle.domain.WordsMatchResults;
import wordle.player.Player;

class PlayingInfo {

    private final Player player;
    private WordsMatchResults wordsMatchResults;
    private Answer answer;
    private Round round;
    private Words inputWords;
    private boolean isCorrect;

    public PlayingInfo(final Player player) {
        this.player = player;
    }

    void init(final Answer answer) {
        round = new Round();
        wordsMatchResults = new WordsMatchResults();
        this.answer = answer;
    }

    void play() {
        round.start();
    }

    boolean isFinish() {
        return round.isFinish() || isCorrect;
    }

    WordsMatchResults getCurrentMatchResults() {
        return wordsMatchResults;
    }

    Round getCurrentRound() {
        return round;
    }

    boolean isCorrect() {
        return isCorrect;
    }

    WordsMatchResult matches() {
        return answer.matches(inputWords);
    }

    Words inputWords() {
        this.inputWords = player.inputWords();
        return inputWords;
    }

    void updateResult(final WordsMatchResult matchResult) {
        isCorrect = matchResult.isCorrect();
        wordsMatchResults.add(matchResult);
    }
}