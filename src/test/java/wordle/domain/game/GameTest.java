package wordle.domain.game;

import wordle.domain.matching.MatchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void 종료_조건_테스트_6턴_이내() {
        // given
        GameResult result = new GameResult();
        MatchResult[] resultArray = new MatchResult[] {
                MatchResult.GRAY, MatchResult.GRAY, MatchResult.GRAY,
                MatchResult.GRAY, MatchResult.GRAY
        };
        for (int i = 0; i < 5; i++) {
            result.addBoard(resultArray);
        }
        Game game = new Game(result);
        // when & then
        Assertions.assertTrue(game.canTry());
    }

    @Test
    public void 종료_조건_테스트_6턴_초과_불가() {
        // given
        GameResult result = new GameResult();
        MatchResult[] resultArray = new MatchResult[] {
                MatchResult.GRAY, MatchResult.GRAY, MatchResult.GRAY,
                MatchResult.GRAY, MatchResult.GRAY
        };
        for (int i = 0; i < 6; i++) {
            result.addBoard(resultArray);
        }
        Game game = new Game(result);
        // when
        boolean canTry = game.canTry();
        // then (size is 6, so currentTryCount is 7, 7 > 6)
        Assertions.assertFalse(canTry);
    }

    @Test
    public void 종료_조건_정답_성공_시_종료() {
        // given
        GameResult result = new GameResult();
        MatchResult[] correctResultValueArray = new MatchResult[] {
                MatchResult.GREEN, MatchResult.GREEN, MatchResult.GREEN, MatchResult.GREEN, MatchResult.GREEN
        };
        result.addBoard(correctResultValueArray);

        Game game = new Game(result);
        // when
        game.checkFinished();
        // then
        Assertions.assertTrue(game.isFinished());
    }

    @Test
    public void 종료_조건_정답_실패_시_종료안됨() {
        // given
        GameResult result = new GameResult();
        MatchResult[] incorrectResultValueArray = new MatchResult[] {
                MatchResult.GRAY, MatchResult.GRAY, MatchResult.GRAY, MatchResult.GRAY, MatchResult.GRAY
        };
        result.addBoard(incorrectResultValueArray);

        Game game = new Game(result);
        // when
        game.checkFinished();
        // then
        Assertions.assertFalse(game.isFinished());
    }
}
