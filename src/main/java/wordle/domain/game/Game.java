package wordle.domain.game;

import wordle.domain.matching.MatchResult;
import wordle.domain.word.WordCondition;

public class Game {

    private static final int MAX_TRY_COUNT = WordCondition.MAX_TRY_COUNT.value();
    private static final String CORRECT_ANSWER_LINE = MatchResult.getCorrectAnswerLine();

    private final GameResult gameResult;
    private boolean isFinished;

    public Game(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void checkFinished() {
        if (CORRECT_ANSWER_LINE.equals(gameResult.getLastBoard())) {
            this.isFinished = true;
            return;
        }
        if (MAX_TRY_COUNT < gameResult.getTryCount()) {
            this.isFinished = true;
        }
    }

    public boolean canTry() {
        return gameResult.getTryCount() <= MAX_TRY_COUNT;
    }

    public boolean isFinished() {
        return this.isFinished;
    }
}
