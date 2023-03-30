package acceptance;

import static acceptance.support.WordGameSupporter.게임_결과가_반환된다;
import static acceptance.support.WordGameSupporter.남은_시도_횟수가_반환된다;
import static acceptance.support.WordGameSupporter.모든_게임_결과가_CORRECT로_반환된다;
import static acceptance.support.WordGameSupporter.시도_횟수는_변하지_않는다;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static woowaapplication.pair.game.wordle.WordleBlock.CORRECT;
import static woowaapplication.pair.game.wordle.WordleBlock.EXIST_BUT_WRONG_SPOT;
import static woowaapplication.pair.game.wordle.WordleBlock.WRONG;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import woowaapplication.pair.game.wordle.Coin;
import woowaapplication.pair.game.wordle.PlayResult;
import woowaapplication.pair.game.wordle.WordleGame;

@DisplayName("워들 인수 테스트")
public class WordleGameAcceptanceTest {

    private String 오늘의_정답_키워드 = "jason";
    private LocalDate 비교_날짜 = LocalDate.of(2021, 6, 24);
    private Coin 코인;
    private WordleGame 워들_게임;

    @BeforeEach
    void setUp() {
        코인 = new Coin(WordleGame.TOTAL_CHANCE);
        워들_게임 = new WordleGame(코인, 비교_날짜);
    }


    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 정답_케이스 {

        @Nested
        @DisplayName("정답 키워드를 입력하면")
        class Context_with_corrected_keyword {

            @Test
            @DisplayName("남은 시도 횟수가 그대로 반환되고 5개의 네모칸이 모두 초록색으로 반환된다")
            void it_returns_remaining_chance_and_answer() {
                PlayResult 게임_결과 = 워들_게임.play(오늘의_정답_키워드);

                assertAll(
                        () -> 모든_게임_결과가_CORRECT로_반환된다(게임_결과),
                        () -> 남은_시도_횟수가_반환된다(게임_결과, WordleGame.TOTAL_CHANCE)
                );
            }
        }
    }

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 실패_케이스 {

        @Nested
        @DisplayName("오답 키워드를 입력하면")
        class Context_with_input_incorrect_keyword {

            private final String 오답_키워드 = "jxosn";

            @Test
            @DisplayName("남은 시도 횟수가 1 감소되고 올바른 알파벳인 자리는 초록색, 위치가 틀린 자리는 노란색, 오답은 흰색으로 표시한다")
            void it_returns_answer_and_decrease_rest_chance() {
                int 기존_남은_시도_횟수 = 워들_게임.getRestChance();
                PlayResult 게임_결과 = 워들_게임.play(오답_키워드);

                assertAll(
                        () -> 게임_결과가_반환된다(게임_결과, CORRECT, WRONG, EXIST_BUT_WRONG_SPOT, EXIST_BUT_WRONG_SPOT, CORRECT),
                        () -> 남은_시도_횟수가_반환된다(게임_결과, 기존_남은_시도_횟수 - 1)
                );
            }
        }
    }

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 입력_검증_예외_케이스 {

        @Nested
        @DisplayName("알파벳이 아닌 입력이 들어오면")
        class Context_with_not_string_input {

            private final String 알파벳이_아닌_키워드 = "12345";

            @Test
            @DisplayName("시도가 무효된다")
            void it_makes_chance_canceled() {
                int 기존_남은_횟수 = 워들_게임.getRestChance();

                assertAll(
                        () -> assertThatThrownBy(() -> 워들_게임.play(알파벳이_아닌_키워드))
                                .isInstanceOf(IllegalArgumentException.class),
                        () -> 시도_횟수는_변하지_않는다(워들_게임, 기존_남은_횟수)
                );
            }
        }

        @Nested
        @DisplayName("글자수 제한에 맞지 않는 입력이 들어오면")
        class Context_with_over_limit_input {

            private final String 글자수_제한에_맞지_않는_키워드 = "alexholden";

            @Test
            @DisplayName("시도가 무효된다")
            void it_makes_chance_canceled() {
                int 기존_남은_횟수 = 워들_게임.getRestChance();

                assertAll(
                        () -> assertThatThrownBy(() -> 워들_게임.play(글자수_제한에_맞지_않는_키워드))
                                .isInstanceOf(IllegalArgumentException.class),
                        () -> 시도_횟수는_변하지_않는다(워들_게임, 기존_남은_횟수)
                );
            }
        }
    }
}
