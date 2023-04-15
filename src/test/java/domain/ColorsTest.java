package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ColorsTest {

    @Test
    void 게임종료_여부_확인() {
        Colors colors = new Colors(
            List.of(Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));

        Assertions.assertThat(colors.isAllGreen()).isTrue();
    }
}