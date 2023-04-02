package domain;

import java.util.ArrayList;
import java.util.List;

public class Tiles {

    // ⬜⬜🟨🟩⬜
    private List<Tile> tiles = new ArrayList<>();

    public List<Tile> getTiles() {
        return tiles;
    }

    public void addTiles(Tile tile) {
        tiles.add(tile);
    }

}
