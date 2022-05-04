package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @ValueSource(chars = {'1', '?', '갑'})
    void Tile은_알파벳만_입력이_가능하다(char input) {
        assertThatThrownBy(() -> new Tile(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(input + "는 알파벳이 아님");
    }

    @ParameterizedTest
    @CsvSource(value = {"A:a", "D:d", "Z:z"},delimiter = ':')
    void Tile은_대문자를_입력받으면_소문자로_변경한다(char upper, char lower) {
        Tile tile = new Tile(upper);

        assertThat(tile.getValue()).isEqualTo(lower);
    }

    @Test
    void 두_Tile이_일치하면_참(){
        Tile tile = new Tile('a');
        Tile anotherTile = new Tile('a');

        assertThat(tile).isEqualTo(anotherTile);
    }
    @Test
    void 두_Tile이_다르면_거짓(){
        Tile tile = new Tile('a');
        Tile anotherTile = new Tile('b');

        assertThat(tile).isNotEqualTo(anotherTile);
    }

}
