package domain;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    // 5개의 타일
    private final List<TileColor> tileColors;

    public Tile() {
        tileColors = new ArrayList<>();
    }

    public void addTile(TileColor tileColor) {
        tileColors.add(tileColor);
    }

}
