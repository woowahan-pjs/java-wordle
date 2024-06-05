package unit;

import static org.assertj.core.api.Assertions.assertThat;
import static woowaapplication.pair.game.wordle.domain.WordleBlock.CORRECT;
import static woowaapplication.pair.game.wordle.domain.WordleBlock.EXIST_BUT_WRONG_SPOT;
import static woowaapplication.pair.game.wordle.domain.WordleBlock.WRONG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import woowaapplication.pair.game.wordle.WordleGame;
import woowaapplication.pair.game.wordle.domain.Coin;
import woowaapplication.pair.game.wordle.domain.WordleBlock;
import woowaapplication.pair.game.wordle.WordleGameStorage;

@DisplayName("워들 게임 저장소 테스트")
class WordleGameStorageTest {
    private WordleGameStorage wordleGameStorage;

    @BeforeEach
    void setUp() {
        Coin coin = Coin.of(WordleGame.TOTAL_CHANCE);
        wordleGameStorage = WordleGameStorage.of(coin);
    }

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 정답_확인_기능 {

        @Nested
        @DisplayName("정답으로 구성된 워들 블럭들이 주어진다면")
        class Context_with_clear_wordle_blocks {
            private WordleBlock[] 워들_블럭들 = {CORRECT, CORRECT, CORRECT, CORRECT, CORRECT};

            @Test
            @DisplayName("게임 엔드 판단한다")
            void it_clear_game() {
                wordleGameStorage.submit(워들_블럭들);

                assertThat(wordleGameStorage.isGameEnd()).isTrue();
            }
        }

        @Nested
        @DisplayName("정답이 아닌 것이 존재하는 워들 블럭들이 주어진다면")
        class Context_with_not_clear_wordle_blocks {
            private WordleBlock[] 워들_블럭들 = {CORRECT, WRONG, EXIST_BUT_WRONG_SPOT, CORRECT, CORRECT};

            @Test
            @DisplayName("게임 클리어 실패로 판단한다")
            void it_clear_game() {
                wordleGameStorage.submit(워들_블럭들);

                assertThat(wordleGameStorage.isGameEnd()).isFalse();
            }
        }
    }

}
