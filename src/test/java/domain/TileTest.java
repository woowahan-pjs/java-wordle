package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TileTest {

    @Test
    void Tile_생성시_TileColors_사이즈가_5보다_클경우_예외가_발생한다() {
        List<TileColor> tileColors = List.of(
                TileColor.WHITE,
                TileColor.WHITE,
                TileColor.YELLOW,
                TileColor.GREEN,
                TileColor.WHITE,
                TileColor.WHITE
        );

        assertThrows(IllegalArgumentException.class, () -> new Tile(tileColors));
    }

    @Test
    void Tile_생성시_TileColors_사이즈가_5보다_작을경우_예외가_발생한다() {
        List<TileColor> tileColors = List.of(
                TileColor.WHITE,
                TileColor.WHITE,
                TileColor.YELLOW,
                TileColor.GREEN
        );

        assertThrows(IllegalArgumentException.class, () -> new Tile(tileColors));
    }

    @Test
    void 모든_TileColors가_Green인경우_true를_반환한다() {
        List<TileColor> tileColors = List.of(
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.GREEN
        );
        Tile tile = new Tile(tileColors);

        boolean actual = tile.isAllGreen();

        assertTrue(actual);
    }

    @Test
    void TileColor중_Green이_아닌_Color가_존재할경우_false를_반환한다() {
        List<TileColor> tileColors = List.of(
                TileColor.GREEN,
                TileColor.GREEN,
                TileColor.YELLOW,
                TileColor.GREEN,
                TileColor.GREEN
        );
        Tile tile = new Tile(tileColors);

        boolean actual = tile.isAllGreen();

        assertFalse(actual);
    }

    @Test
    void 다섯개의_TileColor을_문자열로_반환한다() {
        List<TileColor> tileColors = List.of(
                TileColor.WHITE,
                TileColor.WHITE,
                TileColor.YELLOW,
                TileColor.GREEN,
                TileColor.WHITE
        );

        Tile tile = new Tile(tileColors);

        // ⬜⬜🟨🟩⬜
        String expected = "⬜⬜\uD83D\uDFE8\uD83D\uDFE9⬜";
        String actual = tile.printTile();

        assertThat(expected).isEqualTo(actual);
    }
}