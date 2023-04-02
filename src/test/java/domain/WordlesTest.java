package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordlesTest {

    @ParameterizedTest
    @CsvSource(value = {"abcdef:abcde", "abcde:abcdef", "aaaaaaaaa:aaaaaaaa"}, delimiter = ':')
    void Wordles_생성시_단어가_5글자보다_긴경우_예외를_반환한다(String answer, String input) {
        assertThrows(IllegalArgumentException.class, () -> new Wordles(answer, input));
    }

    @ParameterizedTest
    @CsvSource(value = {"abcd:abcd", "abcd:abcde", "abcde:abcd"}, delimiter = ':')
    void Wordles_생성시_단어가_5글자보다_짧은경우_예외를_반환한다(String answer, String input) {
        assertThrows(IllegalArgumentException.class, () -> new Wordles(answer, input));
    }

    @ParameterizedTest
    @CsvSource(value = {"ab1cd:abcde", "abcde:ab1cd", "123ab:42918"}, delimiter = ':')
    void Wordles_생성시_영단어가_아닐경우_예외를_반환한다(String answer, String input) {
        assertThrows(IllegalArgumentException.class, () -> new Wordles(answer, input));
    }

    @Test
    void 정답과_인풋_단어가_모두_동일한경우_전부_GREEN을_반환한다() {
        Wordles wordles = new Wordles("spill", "spill");

        List<TileColor> result = wordles.makeTileColorList();

        assertThat(result).contains(
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.GREEN
        );
    }

    @Test
    void 정답과_인풋_단어가_모두_다른경우_전부_WHIE을_반환한다() {
        Wordles wordles = new Wordles("spill", "maybe");

        List<TileColor> result = wordles.makeTileColorList();

        assertThat(result).contains(
                TileColor.WHITE,
                TileColor.WHITE,
                TileColor.WHITE,
                TileColor.WHITE,
                TileColor.WHITE
        );
    }

    @Test
    void WHIE_YELLOW_GREEN을_모두_포함한다() {
        Wordles wordles = new Wordles("spill", "sleep");

        List<TileColor> result = wordles.makeTileColorList();

        assertThat(result).contains(
                TileColor.GREEN,
                TileColor.YELLOW,
                TileColor.WHITE,
                TileColor.WHITE,
                TileColor.YELLOW
        );
    }

}
