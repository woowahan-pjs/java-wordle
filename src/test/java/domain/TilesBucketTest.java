package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TilesBucketTest {

    @Test
    void words텍스트파일에서_tiles들을_생성한다() {
        TilesBucket tilesBucket = new TilesBucket("src/main/resources/words.txt");

        assertThat(tilesBucket.getTiles()).isNotEmpty();
    }
}
