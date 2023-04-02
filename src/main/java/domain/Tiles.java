package domain;

import java.util.List;

public class Tiles {

    // ⬜⬜🟨🟩⬜
    private List<Tile> tiles;

    public List<Tile> getTiles() {
        return tiles;
    }

    public void addTiles(Tile tile) {
        tiles.add(tile);
    }

}
