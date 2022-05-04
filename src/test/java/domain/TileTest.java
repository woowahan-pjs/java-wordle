package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TileTest {

    @ParameterizedTest
    @ValueSource(chars = {'a', 'b', 'c'})
    void Tile은_하나의_문자를_가지고_있다(char input) {
        Tile tile = new Tile(input);

        assertThat(tile.getValue()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(chars = {'1','?','갑'})
    void Tile은_알파벳만_입력이_가능하다(char input){
        assertThatThrownBy(() -> new Tile(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(input + "는 알파벳이 아님");

    }

}
