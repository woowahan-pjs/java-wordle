package domain;

import java.util.ArrayList;
import java.util.List;

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
}
