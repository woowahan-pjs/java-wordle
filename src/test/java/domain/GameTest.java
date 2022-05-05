package domain;

import mock.WordsMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GameTest {

    private final Words words = new WordsMock();

    @Test
    @DisplayName("게임의 초기 상태 테스트")
    void initialGame() {

        Game game = Game.start(words);

        assertThat(game.isNotFinish()).isTrue();
    }

    @Test
    @DisplayName("게임에서 이기는 경우 테스트")
    void isWinGame() {
        Game game = Game.start(words);
        GameStatus result = game.playGame("hello");

        assertAll(() -> {
            assertThat(game.isNotFinish()).isFalse();
            assertThat(result).isEqualTo(GameStatus.WIN);
        });
    }

    @Test
    @DisplayName("게임이 진행되는 중")
    void isProgressGame() {
        Game game = Game.start(words);
        GameStatus result = game.playGame("apple");

        assertAll(() -> {
            assertThat(game.isNotFinish()).isTrue();
            assertThat(result).isEqualTo(GameStatus.PROGRESS);
        });
    }

    @Test
    @DisplayName("게임에서 지는 경우 테스트")
    void isLoseGame() {
        Game game = Game.start(words);
        game.playGame("story");
        game.playGame("glory");
        game.playGame("apple");
        game.playGame("model");
        game.playGame("karma");
        GameStatus lastGameStatus = game.playGame("grade");

        assertAll(() -> {
            assertThat(game.isNotFinish()).isFalse();
            assertThat(lastGameStatus).isEqualTo(GameStatus.LOSE);
        });
    }
}
