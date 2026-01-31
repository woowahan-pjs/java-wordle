package wordle.domain;

import wordle.exception.WordException;

import java.util.HashMap;
import java.util.Map;

public class Referee {
    private static final int WORD_LENGTH = 5;

    private final String targetWord;
    private final Map<Character, Integer> targetWordMap = new HashMap<>();

    public Referee(final String targetWord) {
        if (targetWord.length() != WORD_LENGTH) {
            throw new WordException("단어가 5글자여야 합니다.");
        }
        this.targetWord = targetWord;

        for (char targetWordChar : targetWord.toCharArray()) {
            targetWordMap.put(targetWordChar, targetWordMap.getOrDefault(targetWordChar, 0) + 1);
        }
    }

    public Tile[] checkWordle(final String guessWord) {
        Tile[] result = new Tile[targetWord.length()];
        HashMap<Character, Integer> remainedTargetWordMap = new HashMap<>(targetWordMap);

        markGreen(guessWord, result, remainedTargetWordMap);
        markYellowOrGray(guessWord, result, remainedTargetWordMap);
        return result;
    }

    private void markGreen(final String guessWord, final Tile[] result, final HashMap<Character, Integer> remainedTargetWordMap) {
        for (int i = 0; i < guessWord.length(); i++) {
            char targetWordChar = targetWord.charAt(i);
            if (targetWordChar == guessWord.charAt(i)) {
                result[i] = Tile.GREEN;
                remainedTargetWordMap.put(targetWordChar, remainedTargetWordMap.get(targetWordChar) - 1);
            }
        }
    }

    private void markYellowOrGray(final String guessWord, final Tile[] result, final HashMap<Character, Integer> remainedTargetWordMap) {
        for (int i = 0; i < guessWord.length(); i++) {
            if (result[i] == Tile.GREEN) {
                continue;
            }

            char guessChar = guessWord.charAt(i);
            if (remainedTargetWordMap.getOrDefault(guessChar, 0) > 0) {
                result[i] = Tile.YELLOW;
                remainedTargetWordMap.put(guessChar, remainedTargetWordMap.get(guessChar) - 1);
                continue;
            }
            result[i] = Tile.GRAY;
        }
    }
}
