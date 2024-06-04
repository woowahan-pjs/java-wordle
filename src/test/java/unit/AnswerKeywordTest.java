package unit;

import static org.assertj.core.api.Assertions.assertThat;
import static woowaapplication.pair.game.wordle.WordleBlock.CORRECT;
import static woowaapplication.pair.game.wordle.WordleBlock.EXIST_BUT_WRONG_SPOT;
import static woowaapplication.pair.game.wordle.WordleBlock.WRONG;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import woowaapplication.pair.game.wordle.AnswerKeyword;
import woowaapplication.pair.game.wordle.WordleBlock;

@DisplayName("정답 키워드 기능 관련 테스트")
class AnswerKeywordTest {

    public final LocalDate 비교날짜 = LocalDate.of(2021, 6, 24);
    private final AnswerKeyword 오늘의_정답_키워드 = new AnswerKeyword(비교날짜);
    private final String 정답인_키워드 = "jason";

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 날짜_기반_정답_단어_가져오는_기능 {

        @Nested
        @DisplayName("단어 목록 파일을 통해 워들 게임의 당일 정답 단어를 가져오면")
        class Context_with_today_keyword {

            @Test
            @DisplayName("예상한 정답 단어와 일치한다")
            void it_returns_today_keyword() {
                assertThat(오늘의_정답_키워드.isCorrect(정답인_키워드)).isTrue();
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 정답_결과를_워들_블럭으로_변환하는_기능 {

        @Nested
        @DisplayName("정답인 키워드를 워들 블럭으로 변환하면")
        class Context_with_convert_correct_keyword_to_wordle_blocks {

            @Test
            @DisplayName("초록색 블럭 5개가 반환된다")
            void it_returns_all_correct() {
                WordleBlock[] 정답인_워들_블럭_목록 = 오늘의_정답_키워드.convertToWordleBlocks(정답인_키워드);

                assertThat(정답인_워들_블럭_목록).containsExactly(CORRECT, CORRECT, CORRECT, CORRECT, CORRECT);
            }
        }

        @Nested
        @DisplayName("오답인 키워드를 워들 블럭으로 변환하면")
        class Context_with_convert_incorrect_keyword_to_wordle_blocks {

            private final String 오답인_키워드 = "jxosn";

            @Test
            @DisplayName("올바른 알파벳인 자리는 초록색, 위치가 틀린 자리는 노란색, 오답은 흰색으로 표시한다")
            void it_returns_suitable_results_for_each() {
                WordleBlock[] 정답인_워들_블럭_목록 = 오늘의_정답_키워드.convertToWordleBlocks(오답인_키워드);

                assertThat(정답인_워들_블럭_목록).containsExactly(
                        CORRECT,
                        WRONG,
                        EXIST_BUT_WRONG_SPOT,
                        EXIST_BUT_WRONG_SPOT,
                        CORRECT
                );
            }
        }
    }
}
