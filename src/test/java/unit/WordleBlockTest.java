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

@DisplayName("워들 블럭 관리 기능 테스트")
class WordleBlockTest {

    @Nested
    @DisplayNameGeneration(ReplaceUnderscores.class)
    class 워들_블럭_결과_목록을_네모칸_이모지로_변환하는_기능 {

        @Nested
        @DisplayName("워들 블럭 결과 목록을 네모칸 이모지로 변환하면")
        class Context_with_wordle_block_list {
            private WordleBlock[] 워들_블럭_목록 = {CORRECT, EXIST_BUT_WRONG_SPOT, WRONG};

            @Test
            @DisplayName("네모칸 이모지로 변환된 목록을 반환한다")
            void it_returns_emoji_list() {
                String[] 네모칸_이모지_목록 = WordleBlock.toEmojiList(워들_블럭_목록);

                assertThat(네모칸_이모지_목록).containsExactly("🟩", "🟨", "⬜");
            }
        }

        @Nested
        @DisplayName("워들 블럭 결과 목록이 비어있으면")
        class Context_with_empty_wordle_block_list {
            private WordleBlock[] 워들_블럭_목록 = {};

            @Test
            @DisplayName("비어있는 목록을 반환한다")
            void it_returns_empty_list() {
                String[] 네모칸_이모지_목록 = WordleBlock.toEmojiList(워들_블럭_목록);

                assertThat(네모칸_이모지_목록).isEmpty();
            }
        }
    }
}
