package acceptance.support;

import static org.assertj.core.api.Assertions.assertThat;

import woowaapplication.pair.game.wordle.WordleGame;
import woowaapplication.pair.game.wordle.dto.GameResultDto;

public class WordGameSupporter {

    private static String 정답_기록 = "🟩 🟩 🟩 🟩 🟩";

    private static int 전체_시도_횟수 = WordleGame.TOTAL_CHANCE;

    public static void 정답_기록이_올바르다(GameResultDto 게임_결과) {
        assertThat(게임_결과.getHistory()).isEqualTo(정답_기록);
    }

    public static void 게임_기록이_올바르다(GameResultDto 게임_결과, String 예상_결과) {
        assertThat(게임_결과.getHistory()).isEqualTo(예상_결과);
    }

    public static void 시도_횟수가_올바르다(GameResultDto 게임_결과, int 예상_시도_횟수) {
        String 올바른_시도_횟수 = (전체_시도_횟수 - 예상_시도_횟수) + "/" + 전체_시도_횟수;

        assertThat(게임_결과.getChance()).isEqualTo(올바른_시도_횟수);
    }
}
