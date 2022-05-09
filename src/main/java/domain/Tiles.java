package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tiles {
    private static final String INVALID_TILES_MESSAGE = "Tiles는 5개의 Tile로 구성되어야 한다.";
    private static final int TILES_SIZE = 5;
    private final List<Tile> tiles;

    public Tiles(String input) {
        if (input.length() != TILES_SIZE) {
            throw new IllegalArgumentException(INVALID_TILES_MESSAGE);
        }
        tiles = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            tiles.add(new Tile(input.charAt(i), i));
        }
    }

    public boolean contains(Tile tile) {
        return tiles.contains(tile);
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tiles tiles1 = (Tiles) o;
        return Objects.equals(getTiles(), tiles1.getTiles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTiles());
    }

    @Override
    public String toString() {
        return "Tiles{" +
                "tiles=" + tiles +
                '}';
    }
}
