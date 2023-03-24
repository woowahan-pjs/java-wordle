package acceptance.support;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import woowaapplication.pair.game.wordle.PlayResult;
import woowaapplication.pair.game.wordle.WordleBlock;
import woowaapplication.pair.game.wordle.WordleGame;

public class WordGameSupporter {

    public static void 모든_게임_결과가_CORRECT로_반환된다(PlayResult 게임_결과) {
        assertThat(Arrays.stream(게임_결과.getWordleBlocks())
                .allMatch(res -> res == WordleBlock.CORRECT))
                .isTrue();
    }

    public static void 남은_시도_횟수가_반환된다(PlayResult 게임_결과, int 남은_예상_기회_횟수) {
        assertThat(게임_결과.getCoin().getRestChance())
                .isSameAs(남은_예상_기회_횟수);
    }

    public static void 시도_횟수는_변하지_않는다(WordleGame 워들_게임, int 기존_남은_횟수) {
        assertThat(워들_게임.getRestChance()).isEqualTo(기존_남은_횟수);
    }

    public static void 게임_결과가_반환된다(PlayResult 게임_결과, WordleBlock... 각_칸의_결과) {
        assertArrayEquals(게임_결과.getWordleBlocks(), 각_칸의_결과);
    }
}
