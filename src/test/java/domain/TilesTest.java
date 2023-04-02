package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class TilesTest {
    @Test
    void allGreenTile_가지고_있으면_true_반환() {
        List<TileColor> tileColors = List.of(TileColor.GREEN,TileColor.GREEN,TileColor.GREEN,TileColor.GREEN,TileColor.GREEN);
        Tile tile = new Tile(tileColors);
        Tiles tiles = new Tiles();
        tiles.addTiles(tile);

        assertThat(tiles.hasAllGreen()).isTrue();
    }

    @Test
    void allGreenTile_없으면_false_반환() {
        List<TileColor> tileColors = List.of(TileColor.GREEN,TileColor.GREEN,TileColor.GREEN,TileColor.WHITE,TileColor.WHITE);
        Tile tile = new Tile(tileColors);
        Tiles tiles = new Tiles();
        tiles.addTiles(tile);

        assertThat(tiles.hasAllGreen()).isFalse();
    }

    @Test
    void tiles_출력_메시지_확인() {
        List<TileColor> tileColors = List.of(TileColor.GREEN,TileColor.GREEN,TileColor.GREEN,TileColor.WHITE,TileColor.WHITE);
        Tile tile = new Tile(tileColors);
        List<TileColor> tileColors2 = List.of(TileColor.GREEN,TileColor.YELLOW,TileColor.GREEN,TileColor.YELLOW,TileColor.WHITE);
        Tile tile2 = new Tile(tileColors2);

        Tiles tiles = new Tiles();
        tiles.addTiles(tile);
        tiles.addTiles(tile2);

        assertThat(tiles.print()).isEqualTo(
                "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9⬜⬜\n\uD83D\uDFE9\uD83D\uDFE8\uD83D\uDFE9\uD83D\uDFE8⬜"
        );
    }
}
