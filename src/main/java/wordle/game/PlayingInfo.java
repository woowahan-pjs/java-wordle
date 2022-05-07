package wordle.game;

import wordle.domain.Answer;
import wordle.domain.Words;
import wordle.domain.MatchResult;
import wordle.domain.MatchResults;
import wordle.player.Player;

class PlayingInfo {

    private final Player player;
    private MatchResults matchResults;
    private Answer answer;
    private Round round;
    private Words inputWords;
    private boolean isCorrect;

    public PlayingInfo(final Player player) {
        this.player = player;
    }

    void init(final Answer answer) {
        round = new Round();
        matchResults = new MatchResults();
        this.answer = answer;
    }

    void play() {
        round.start();
    }

    boolean isFinish() {
        return round.isFinish() || isCorrect;
    }

    MatchResults getCurrentMatchResults() {
        return matchResults;
    }

    Round getCurrentRound() {
        return round;
    }

    boolean isCorrect() {
        return isCorrect;
    }

    MatchResult matches() {
        return answer.matches(inputWords);
    }

    Words inputWords() {
        this.inputWords = player.inputWords();
        return inputWords;
    }

    void updateResult(final MatchResult matchResult) {
        isCorrect = matchResult.isCorrect();
        matchResults.add(matchResult);
    }
}