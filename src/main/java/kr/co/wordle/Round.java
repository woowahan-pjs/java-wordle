package kr.co.wordle;

import java.util.EnumMap;
import java.util.Map;

public class Round {

    private final String input;
    private final Map<Tile, Integer> result;

    public Round(String input) {
        this.input = input;
        this.result = new EnumMap<>(Tile.class);
    }

    public Map<Tile, Integer> roundResult(Answer answer) {
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            Tile key = getTile(answer, i, inputChars[i]);
            result.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
        }
        return result;
    }

    public Tile getTile(Answer answer, int index, char target) {
        if (answer.charAt(index) == target) {
            return Tile.GREEN;
        }
        if (answer.contains(target)) {
            return Tile.YELLOW;
        }
        return Tile.GRAY;
    }
}
