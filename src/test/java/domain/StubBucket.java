package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StubBucket implements Bucket {
    List<Tiles> tiles = new ArrayList<>();


    public StubBucket(String wordsPath) {
        tiles.add(new Tiles("story"));
    }

    @Override
    public List<Tiles> getTiles() {
        return tiles;
    }

    @Override
    public Answer getAnswer(LocalDate today) {
        return new Answer(new Tiles("story"));
    }

    @Override
    public boolean contains(Tiles tiles) {
        return false;
    }
}
