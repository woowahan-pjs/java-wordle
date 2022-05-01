package wordle.game;

import camp.nextstep.edu.missionutils.Console;
import wordle.domain.*;

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
        final Words words = new Words(Console.readLine());
        this.inputWords = words;

        return words;
    }

    void updateResult(final WordsMatchResult matchResult) {
        isCorrect = matchResult.isCorrect();
        wordsMatchResults.add(matchResult);
    }
}