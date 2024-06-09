package kr.co.wordle;

import java.util.EnumMap;
import java.util.Map;

public class Round {

    private final String input;
    private final Map<Tile, Integer> result;

    public Round(String input) {
        validateInput(input);
        this.input = input;
        this.result = new EnumMap<>(Tile.class);
    }

    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.length() != 5) {
            throw new IllegalArgumentException();
        }
        char[] inputChars = input.toLowerCase().toCharArray();
        for (char ch : inputChars) {
            if (ch < 'a' || ch > 'z') {
                throw new IllegalArgumentException();
            }
        }
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
