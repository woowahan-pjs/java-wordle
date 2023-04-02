package domain;

import java.util.List;

public class Tile {

    // 5개의 타일
    private final List<TileColor> tileColors;

    public Tile(List<TileColor> tileColors) {
        this.tileColors = tileColors;
    }

    public List<TileColor> getTileColors() {
        return tileColors;
    }

    public boolean isAllGreen() {
        return tileColors.stream()
                .allMatch(t -> t.equals(TileColor.GREEN));
    }
}
