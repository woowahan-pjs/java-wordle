package unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static woowaapplication.pair.game.wordle.WordleBlock.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import woowaapplication.pair.game.wordle.Coin;
import woowaapplication.pair.game.wordle.PlayResult;
import woowaapplication.pair.game.wordle.WordleBlock;
import woowaapplication.pair.game.wordle.WordleGame;


public class WordleGameTest {

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
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 날짜_기반_정답_단어_가져오는_기능 {

        @Nested
        @DisplayName("워들 게임에서 정답 단어를 가져오면")
        class Context_with_today_keyword {

            @Test
            @DisplayName("예상한 정답 단어와 일치한다")
            void it_returns_today_keyword() {
                String answerKeyword = 워들_게임.getAnswerKeyword();

                assertThat(answerKeyword).isEqualTo(오늘의_정답_키워드);
            }
        }
    }


    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 키워드_정답_여부_체크_기능{

        @Nested
        @DisplayName("정답 키워드를 입력하면")
        class Context_with_correct_input_keyword {

            @Test
            @DisplayName("CORRECT 5개를 반환한다")
            void it_returns_five_correct_block() {
                WordleBlock[] wordleBlocks = 워들_게임.checkAnswer(오늘의_정답_키워드);

                게임_결과가_반환된다(wordleBlocks, CORRECT, CORRECT, CORRECT, CORRECT, CORRECT);
            }
        }

        @Nested
        @DisplayName("3번째 자리 글자가 틀렸지만 다른 자리에 존재하는 경우의 키워드를 입력하면")
        class Context_with_exist_but_wrong_spot_input_keyword {

            private final String 세번째_글자가_틀렸지만_다른_자리에_존재하는_키워드 = "jajon";

            @Test
            @DisplayName("정답 결과로 CORRECT, CORRECT, EXIST_BUT_WRONG_SPOT, CORRECT, CORRECT를 반환한다")
            void it_returns_five_correct_block() {
                WordleBlock[] wordleBlocks = 워들_게임.checkAnswer(세번째_글자가_틀렸지만_다른_자리에_존재하는_키워드);

                게임_결과가_반환된다(wordleBlocks, CORRECT, CORRECT, EXIST_BUT_WRONG_SPOT, CORRECT, CORRECT);
            }
        }

        @Nested
        @DisplayName("3번째 자리 글자가 틀린 경우의 키워드를 입력하면")
        class Context_with_wrong_input_keyword {

            private final String 세번째_글자가_틀린_키워드 = "jacon";

            @Test
            @DisplayName("정답 결과로 CORRECT, CORRECT, WRONG, CORRECT, CORRECT를 반환한다")
            void it_returns_five_correct_block() {
                WordleBlock[] wordleBlocks = 워들_게임.checkAnswer(세번째_글자가_틀린_키워드);

                게임_결과가_반환된다(wordleBlocks, CORRECT, CORRECT, WRONG, CORRECT, CORRECT);
            }
        }

        @Nested
        @DisplayName("두 번째 자리 글자는 틀리고, "
            + "세 번째와 네 번째 자리 글자는 틀리고만 존재하고, "
            + "나머지 글자는 맞는 경우의 키워드를 입력하면")
        class Context_with_custom_input_keyword {

            private final String 주어진_키워드 = "jxosn";

            @Test
            @DisplayName("정답 결과로 CORRECT, WRONG, EXIST_BUT_WRONG_SPOT, EXIST_BUT_WRONG_SPOT, CORRECT 를 반환한다")
            void it_returns_five_correct_block() {
                WordleBlock[] wordleBlocks = 워들_게임.checkAnswer(주어진_키워드);

                게임_결과가_반환된다(wordleBlocks, CORRECT, WRONG, EXIST_BUT_WRONG_SPOT, EXIST_BUT_WRONG_SPOT, CORRECT);
            }
        }
    }


    private static void 게임_결과가_반환된다(WordleBlock[] 게임_결과, WordleBlock... 각_칸의_결과) {
        assertArrayEquals(게임_결과, 각_칸의_결과);
    }
}
