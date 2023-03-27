package unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woowaapplication.pair.game.wordle.Coin;
import woowaapplication.pair.game.wordle.WordleGame;

class WordleGameTest {

    @Test
    @DisplayName("날짜를 기반으로 정답 단어를 가져 오는 기능 테스트")
    void get_today_keyword() {
        // given
        LocalDate targetDate = LocalDate.of(2021, 6, 24);
        WordleGame wordleGame = new WordleGame("spill", new Coin(WordleGame.TOTAL_CHANCE), targetDate);

        // when
        String answerKeyword = wordleGame.getAnswerKeyword();

        // then
        assertThat(answerKeyword).isEqualTo("jasonz");
    }
}
