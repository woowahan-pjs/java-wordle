package unit;

import static org.assertj.core.api.Assertions.assertThat;
import static woowaapplication.pair.game.wordle.WordleGame.TOTAL_CHANCE;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import woowaapplication.pair.game.wordle.Coin;
import woowaapplication.pair.game.wordle.WordleGameService;
import woowaapplication.pair.game.wordle.WordleGameStorage;

@DisplayName("워들 게임 서비스 테스트")
class WordleGameServiceTest {

    public final int 총_기회_횟수 = TOTAL_CHANCE;
    public final LocalDate 비교날짜 = LocalDate.of(2021, 6, 24);
    private final String 오늘의_정답_키워드 = "jason";
    private WordleGameService 워들_게임_서비스;

    @BeforeEach
    void setUp() {
        Coin coin = new Coin(총_기회_횟수);
        WordleGameStorage wordleGameStorage = new WordleGameStorage(coin);
        워들_게임_서비스 = new WordleGameService(wordleGameStorage, 비교날짜);
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
                String answerKeyword = 워들_게임_서비스.getAnswerKeyword();

                assertThat(answerKeyword).isEqualTo(오늘의_정답_키워드);
            }
        }
    }
}
