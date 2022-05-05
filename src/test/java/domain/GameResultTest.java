package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultTest {

    @Test
    @DisplayName("GameResult에 7개 이상 LetterResults가 있으면 에러가 난다")
    void exceptionGameResult() {
        GameResult gameResult = new GameResult();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            gameResult.addResult(new LetterResults());
            gameResult.addResult(new LetterResults());
            gameResult.addResult(new LetterResults());
            gameResult.addResult(new LetterResults());
            gameResult.addResult(new LetterResults());
            gameResult.addResult(new LetterResults());
            gameResult.addResult(new LetterResults());
        });
    }

    @Test
    @DisplayName("GameResult에 6개 인 경우 maxSize는 true이다")
    void gameResultSizeSix() {
        GameResult gameResult = new GameResult();
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());

        assertThat(gameResult.isMaxSize()).isTrue();
    }

    @Test
    @DisplayName("GameResult에 6개가 아닌 경우 maxSize는 false이다")
    void gameResultSizeNotSix() {
        GameResult gameResult = new GameResult();
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());

        assertThat(gameResult.isMaxSize()).isFalse();
    }

    @Test
    @DisplayName("GameResult에 AllGreen이 있는 경우 isAllGreen은 true이다")
    void checkIsContainAllGreen() {
        GameResult gameResult = new GameResult();
        gameResult.addResult(new LetterResults());
        gameResult.addResult(LetterResults.correctAll());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());

        assertThat(gameResult.isAllGreen()).isTrue();
    }

    @Test
    @DisplayName("GameResult에 AllGreen이 없는 경우 isAllGreen은 false이다")
    void checkIsNotContainAllGreen() {
        GameResult gameResult = new GameResult();
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());
        gameResult.addResult(new LetterResults());

        assertThat(gameResult.isAllGreen()).isFalse();
    }
}
