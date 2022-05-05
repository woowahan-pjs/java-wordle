package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TilesBucket {
    List<Tiles> tiles = new ArrayList<>();

    public TilesBucket(String wordsPath) {
        try {
            List<String> words = Files.readAllLines(Path.of(wordsPath));
            for (String word : words) {
                tiles.add(new Tiles(word));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Tiles> getTiles() {
        return tiles;
    }
}
