package unit;

import static org.assertj.core.api.Assertions.assertThat;
import static woowaapplication.pair.game.wordle.WordleBlock.CORRECT;
import static woowaapplication.pair.game.wordle.WordleBlock.EXIST_BUT_WRONG_SPOT;
import static woowaapplication.pair.game.wordle.WordleBlock.WRONG;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import woowaapplication.pair.game.wordle.WordleBlock;

class WordleBlockTest {

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 입력_키워드와_정답_키워드로_워들블럭_리스트를_만드는_기능 {
        private String 정답_키워드 = "jason";

        @Nested
        @DisplayName("입력 키워드가 정답일 경우")
        class Context_with_correct_input_keyword {
            private String 입력_키워드 = "jason";

            @Test
            @DisplayName("CORRECT로 구성된 워들 블럭들을 반환환다")
            void it_returns_correct_wordle_blocks() {
                WordleBlock[] 워들_블럭들 = WordleBlock.toList(입력_키워드, 정답_키워드);

                assertThat(워들_블럭들).containsOnly(CORRECT);
            }
        }

        @Nested
        @DisplayName("입력 키워드가 한 글자도 못맞춘 경우")
        class Context_with_wrong_input_keyword {
            private String 입력_키워드 = "xxxxx";

            @Test
            @DisplayName("WRONG으로 구성된 워들 블럭들을 반환환다")
            void it_returns_correct_wordle_blocks() {
                WordleBlock[] 워들_블럭들 = WordleBlock.toList(입력_키워드, 정답_키워드);

                assertThat(워들_블럭들).containsOnly(WRONG);
            }
        }

        @Nested
        @DisplayName("입력 키워드의 첫번째 글자는 정답이고,"
                + "나머지 글자들은 정답 키워드에 존재하는 글자이지만 다른 위치에 있는 경우")
        class Context_with_exist_but_wrong_spot_input_keyword {

            private String 입력_키워드 = "jjjjj";

            @Test
            @DisplayName("첫번째는 CORRECT, 나머지는 EXIST_BUT_WRONG_SPOT으로 구성된 워들 블럭들을 반환환다")
            void it_returns_correct_wordle_blocks() {
                WordleBlock[] 워들_블럭들 = WordleBlock.toList(입력_키워드, 정답_키워드);

                assertThat(워들_블럭들).containsExactly(CORRECT, EXIST_BUT_WRONG_SPOT, EXIST_BUT_WRONG_SPOT,
                        EXIST_BUT_WRONG_SPOT, EXIST_BUT_WRONG_SPOT);
            }
        }
    }
}
