package wordle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileStorage {

    private List<Tiles> storage = new ArrayList<>();

    public void add(Tiles tiles) {
        storage.add(tiles);
    }

    public List<Tiles> findAll() {
        return Collections.unmodifiableList(storage);
    }
}
