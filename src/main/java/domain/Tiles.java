package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tiles {

    // 5 * n 타일
    private List<Tile> tiles = new ArrayList<>();
    private boolean allGreen;

    public void addTiles(Tile tile) {
        tiles.add(tile);
        if(tile.isAllGreen()) {
            this.allGreen = true;
        }
    }

    public boolean hasAllGreen() {
        return allGreen;
    }

    public String print() {
        return tiles.stream()
                .map(Tile::printTile)
                .collect(Collectors.joining("\n"));
    }
}
