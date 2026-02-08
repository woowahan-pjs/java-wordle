package model;

import java.util.Arrays;
import java.util.List;

public class WordResult {

    private final String[] tiles;
    private final int wordLength;
    private final List<Integer> partialMatchedIndexes ;
    private final List<Integer> perfectlyMatchedIndexes;

    public WordResult(int wordLength, List<Integer> partialIndexes, List<Integer> perfectIndexes) {
        this.wordLength = wordLength;
        this.partialMatchedIndexes  = partialIndexes;
        this.perfectlyMatchedIndexes = perfectIndexes;

        tiles = new String[wordLength];

        Arrays.fill(tiles, TileColor.WHITE.getEmoji());

        for (int index : partialIndexes) {
            tiles[index] = TileColor.YELLOW.getEmoji();
        }

        for (int index : perfectIndexes) {
            tiles[index] = TileColor.GREEN.getEmoji();
        }
    }

    public boolean isPerfect() {
        return perfectlyMatchedIndexes.size() == wordLength;
    }

    public String[] getTiles() {
        return tiles;
    }
}
