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
        Tile tile = new Tile(input, 0);

        assertThat(tile.getValue()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(chars = {'1', '?', '갑'})
    void Tile은_알파벳만_입력이_가능하다(char input) {
        assertThatThrownBy(() -> new Tile(input,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(input + "는 알파벳이 아님");
    }

    @ParameterizedTest
    @CsvSource(value = {"A:a", "D:d", "Z:z"}, delimiter = ':')
    void Tile은_대문자를_입력받으면_소문자로_변경한다(char upper, char lower) {
        Tile tile = new Tile(upper,0);

        assertThat(tile.getValue()).isEqualTo(lower);
    }

    @Test
    void 두_Tile이_일치하면_Green() {
        Tile tile = new Tile('a',0);
        Tile anotherTile = new Tile('a',0);

        assertThat(tile.matches(anotherTile)).isEqualTo(MatchStatus.GREEN);
    }

    @Test
    void 문자는_일치하고_위치가다르면_YELLO() {
        Tile tile = new Tile('a',0);
        Tile anotherTile = new Tile('a',1);

        assertThat(tile.matches(anotherTile)).isEqualTo(MatchStatus.YELLOW);
    }
    @Test
    void 문자ㅘ_위치가_모두_다르면_GREY() {
        Tile tile = new Tile('a',0);
        Tile anotherTile = new Tile('b',1);

        assertThat(tile.matches(anotherTile)).isEqualTo(MatchStatus.GREY);
    }

}
