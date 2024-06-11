package wordle;

import java.util.StringJoiner;

public class TileHistory {
    private final StringJoiner tileHistories = new StringJoiner("\n");

    public void add(String tile) {
        tileHistories.add(tile);
    }

    @Override
    public String toString() {
        return tileHistories.toString();
    }
}
