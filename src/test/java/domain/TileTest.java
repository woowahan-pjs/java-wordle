package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class TileTest {

    @ParameterizedTest
    @ValueSource(chars = {'a', '0', '가'})
    void Tile은_하나의_문자를_가지고_있다(char input) {
        Tile tile = new Tile(input);

        assertThat(tile.getValue()).isEqualTo(input);
    }

}
