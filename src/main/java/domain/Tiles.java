package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tiles {
    private final List<Tile> tiles;

    public Tiles(String input) {
        if (input.length() != 5) {
            throw new IllegalArgumentException("Tiles는 5개의 Tile로 구성되어야 한다.");
        }
        tiles = new ArrayList<>();
        for (char text : input.toCharArray()) {
            tiles.add(new Tile(text));
        }
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
