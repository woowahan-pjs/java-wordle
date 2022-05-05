package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TilesBucketTest {

    @Test
    void words텍스트파일에서_tiles들을_생성한다() {
        TilesBucket tilesBucket = new TilesBucket("src/main/resources/words.txt");

        assertThat(tilesBucket.getTiles()).isNotEmpty();
    }

    @Test
    void words텍스트파일_존재하지않으면_에서_tiles를_읽어온다() {
        assertThatThrownBy(() -> new TilesBucket("src/main/resources/not-exist-words.txt"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("words.txt를 찾을 수 없습니다.");
    }
}
