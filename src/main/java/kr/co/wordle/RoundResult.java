package kr.co.wordle;

import java.util.EnumMap;
import java.util.Map;

public class RoundResult {
    private final Map<Tile, Integer> countPerTile;
    private final StringBuilder result;

    public RoundResult() {
        this.countPerTile = new EnumMap<>(Tile.class);
        result = new StringBuilder();
    }

    public void update(Tile tile) {
        countPerTile.compute(tile, (k, v) -> (v == null) ? 1 : v + 1);
        result.append(tile);
    }

    public boolean isAllGreen() {
        return countPerTile.getOrDefault(Tile.GREEN, 0) == 5;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
