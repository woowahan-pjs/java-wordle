package acceptance;

import static acceptance.support.WordGameSupporter.*;
import static org.junit.jupiter.api.Assertions.*;
import static woowaapplication.pair.game.wordle.WordleGame.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import woowaapplication.pair.game.wordle.WordleGame;
import woowaapplication.pair.game.wordle.domain.Coin;
import woowaapplication.pair.game.wordle.dto.GameResultDto;

@DisplayName("워들 인수 테스트")
public class WordleGameAcceptanceTest {
    private String 정답_키워드 = "jason";

    private final String 오답_키워드 = "jxosn";

    private final String 정답_기록 = "🟩 🟩 🟩 🟩 🟩";

    private final String 오답_기록 = "🟩 ⬜ 🟨 🟨 🟩";

    private Coin 코인;
    private WordleGame 워들_게임;

    @BeforeEach
    void setUp() {
        코인 = Coin.of(TOTAL_CHANCE);
        워들_게임 = of();
    }


    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 정답_케이스 {

        @Nested
        @DisplayName("정답 키워드를 입력하면")
        class Context_with_corrected_keyword {

            @Test
            @DisplayName("남은 시도 횟수가 그대로 반환되고, 5개의 네모칸이 모두 초록색으로 반환된다")
            void it_returns_remaining_chance_and_answer() {
                GameResultDto 게임_결과 = 워들_게임.playRound(정답_키워드, 정답_키워드);

                assertAll(
                        () -> 정답_기록이_올바르다(게임_결과),
                        () -> 시도_횟수가_올바르다(게임_결과, TOTAL_CHANCE - 1)
                );
            }
        }
    }

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 오답_케이스 {

        @Nested
        @DisplayName("오답 키워드를 입력하면")
        class Context_with_input_incorrect_keyword {
            @Test
            @DisplayName("올바른 알파벳인 자리는 초록색, 위치가 틀린 자리는 노란색, 오답은 흰색으로 표시한다")
            void it_returns_answer_and_decrease_rest_chance() {
                int 기존_남은_시도_횟수 = 코인.getRestChance();
                GameResultDto 게임_결과 = 워들_게임.playRound(오답_키워드, 정답_키워드);

                assertAll(
                        () -> 게임_기록이_올바르다(게임_결과, 오답_기록)
                );
            }
        }
    }

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 오답_후_정답_케이스 {

        @Nested
        @DisplayName("오답 키워드 입력 후, 정답 키워드를 입력하면")
        class Context_with_input_incorrect_keyword {
            @Test
            @DisplayName("남은 시도 횟수가 2 감소되고, 오답과 정답을 포함한 게임 기록이 반환된다")
            void it_returns_answer_and_decrease_rest_chance() {
                int 기존_남은_시도_횟수 = 코인.getRestChance();

                워들_게임.playRound(오답_키워드, 정답_키워드);

                GameResultDto 게임_결과 = 워들_게임.playRound(정답_키워드, 정답_키워드);

                assertAll(
                    () -> 게임_기록이_올바르다(게임_결과, 오답_기록+"\n"+정답_기록),
                    () -> 시도_횟수가_올바르다(게임_결과, 기존_남은_시도_횟수 - 2)
                );
            }
        }
    }
}
