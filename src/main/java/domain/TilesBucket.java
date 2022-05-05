package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TilesBucket {
    List<Tiles> tiles = new ArrayList<>();

    public TilesBucket(String wordsPath) {
        if (!Files.exists(Path.of(wordsPath))) {
            throw new IllegalArgumentException("words.txt를 찾을 수 없습니다.");
        }

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
