package unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import woowaapplication.pair.game.wordle.AnswerKeyword;
import woowaapplication.pair.game.wordle.Coin;
import woowaapplication.pair.game.wordle.WordleGame;
import woowaapplication.pair.game.wordle.WordleGameStorage;

@DisplayName("워들 게임 저장소 테스트")
class WordleGameStorageTest {
    private WordleGameStorage wordleGameStorage;
    public final LocalDate 비교날짜 = LocalDate.of(2021, 6, 24);
    private final AnswerKeyword 오늘의_정답_키워드 = new AnswerKeyword(비교날짜);

    @BeforeEach
    void setUp() {
        Coin coin = Coin.of(WordleGame.TOTAL_CHANCE);
        wordleGameStorage = WordleGameStorage.of(coin);
    }

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 정답_확인_기능 {

        @Nested
        @DisplayName("정답인 키워드가 주어지면")
        class Context_with_correct_answer {

            private final String 정답인_키워드 = "jason";

            @Test
            @DisplayName("게임 클리어로 판단한다")
            void it_clear_game() {
                wordleGameStorage.checkAnswer(정답인_키워드, 오늘의_정답_키워드);

                assertThat(wordleGameStorage.isClear()).isTrue();
            }
        }

        @Nested
        @DisplayName("오답인 키워드가 주어지면")
        class Context_with_incorrect_answer {

            private final String 오답인_키워드 = "jxosn";

            @Test
            @DisplayName("게임 클리어 실패로 판단한다")
            void it_not_clear_game() {
                wordleGameStorage.checkAnswer(오답인_키워드, 오늘의_정답_키워드);

                assertThat(wordleGameStorage.isClear()).isFalse();
            }
        }
    }
}
