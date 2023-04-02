package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Tile {
    private final int LIMIT_SIZE = 5;

    private final List<TileColor> tileColors;

    public Tile(List<TileColor> tileColors) {
        validate(tileColors);
        this.tileColors = tileColors;
    }

    private void validate(List<TileColor> tileColors) {
        if (tileColors.size() != LIMIT_SIZE) {
            throw new IllegalArgumentException("TileColors 사이즈는 5 이어야 합니다. 현재 size: " + tileColors.size());
        }
    }

    public boolean isAllGreen() {
        return tileColors.stream()
                .allMatch(t -> t.equals(TileColor.GREEN));
    }

    public String printTile() {
        return tileColors.stream()
                .map(TileColor::getTile)
                .collect(Collectors.joining());
    }
}
