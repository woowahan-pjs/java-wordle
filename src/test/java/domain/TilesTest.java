package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TilesTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcde", "qwert"})
    void Tiles는_5개의_Tile로_구성됨(String input) {
        Tiles tiles = new Tiles(input);

        assertThat(tiles.getTiles().size()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "qwerty"})
    void Tiles는_5개의_Tile이_아닌경우_에러를_발생한다(String input) {
        assertThatThrownBy(() -> new Tiles(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Tiles는 5개의 Tile로 구성되어야 한다.");
    }

}
