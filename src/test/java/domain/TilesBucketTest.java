package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TilesBucketTest {
    private static final String WORDS_PATH = "src/main/resources/words.txt";

    @Test
    void words텍스트파일에서_tiles들을_생성한다() {
        TilesBucket tilesBucket = new TilesBucket(WORDS_PATH);

        assertThat(tilesBucket.getTiles()).isNotEmpty();
    }

    @Test
    void words텍스트파일_존재하지않으면_에서_tiles를_읽어온다() {
        assertThatThrownBy(() -> new TilesBucket("src/main/resources/not-exist-words.txt"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("words.txt를 찾을 수 없습니다.");
    }

    @Test
    void 규칙에의해_정답을_선정한다() {
        TilesBucket tilesBucket = new TilesBucket(WORDS_PATH);
        LocalDate today = LocalDate.of(2022, 5, 5);
        Answer answer = tilesBucket.getAnswer(today);

        assertThat(answer).isNotNull();
        assertThat(answer.matches(new Tiles("story")).isCorrect()).isTrue();
    }
}
