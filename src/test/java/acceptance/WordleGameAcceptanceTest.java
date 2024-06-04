package acceptance;

import static acceptance.support.WordGameSupporter.게임_결과가_반환된다;
import static acceptance.support.WordGameSupporter.남은_시도_횟수는_예상_기회_횟수와_동일하다;
import static acceptance.support.WordGameSupporter.정답_표시가_반환된다;
import static org.junit.jupiter.api.Assertions.assertAll;

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
import woowaapplication.pair.game.wordle.WordleGameService;
import woowaapplication.pair.game.wordle.WordleGameStorage;

@DisplayName("워들 인수 테스트")
public class WordleGameAcceptanceTest {

    private AnswerKeyword 오늘의_정답_키워드;
    private LocalDate 비교_날짜 = LocalDate.of(2021, 6, 24);
    private Coin 코인;
    private WordleGameService 워들_게임;
    private String 정답인_키워드 = "jason";

    @BeforeEach
    void setUp() {
        오늘의_정답_키워드 = new AnswerKeyword(비교_날짜);
        코인 = Coin.of(WordleGame.TOTAL_CHANCE);
        WordleGameStorage wordleGameStorage = WordleGameStorage.of(코인);
        워들_게임 = WordleGameService.of(wordleGameStorage, 오늘의_정답_키워드);
    }

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 정답_케이스 {

        @Nested
        @DisplayName("정답 키워드를 입력하면")
        class Context_with_corrected_keyword {

            @Test
            @DisplayName("남은 시도 횟수가 1 감소하고, 5개의 네모칸이 모두 초록색으로 반환된다")
            void it_returns_remaining_chance_and_answer() {
                String[] 게임_결과 = 워들_게임.playRound(정답인_키워드).get(0);

                assertAll(
                        () -> 정답_표시가_반환된다(게임_결과),
                        () -> 남은_시도_횟수는_예상_기회_횟수와_동일하다(코인, WordleGame.TOTAL_CHANCE - 1)
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
            @DisplayName("남은 시도 횟수가 1 감소하고, 올바른 알파벳인 자리는 초록색, 위치가 틀린 자리는 노란색, 오답은 흰색으로 표시한다")
            void it_returns_answer_and_decrease_rest_chance() {
                int 기존_남은_시도_횟수 = 코인.getRestChance();
                String[] 게임_결과 = 워들_게임.playRound(오답_키워드).get(0);

                assertAll(
                        () -> 게임_결과가_반환된다(게임_결과, "🟩", "⬜", "🟨", "🟨", "🟩"),
                        () -> 남은_시도_횟수는_예상_기회_횟수와_동일하다(코인, 기존_남은_시도_횟수 - 1)
                );
            }
        }
    }
}
