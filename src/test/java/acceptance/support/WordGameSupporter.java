package acceptance.support;

import static org.assertj.core.api.Assertions.assertThat;

import woowaapplication.pair.game.wordle.Coin;

public class WordGameSupporter {

    public static void 정답_표시가_반환된다(String[] 게임_결과) {
        assertThat(게임_결과).containsExactly("🟩", "🟩", "🟩", "🟩", "🟩");
    }

    public static void 게임_결과가_반환된다(String[] 게임_결과, String... 예상_결과) {
        assertThat(게임_결과).containsExactly(예상_결과);
    }

    public static void 남은_시도_횟수는_예상_기회_횟수와_동일하다(Coin 코인, int 남은_예상_기회_횟수) {
        assertThat(코인.getRestChance()).isSameAs(남은_예상_기회_횟수);
    }
}
