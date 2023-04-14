package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ColorsTest {

    @DisplayName("Colors equals 테스트")
    @Test
    void equalsTest() {
        List<Color> green = List.of(Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);
        Colors colors = new Colors(green);
        assertThat(colors.isAllGreen()).isTrue();
    }
}