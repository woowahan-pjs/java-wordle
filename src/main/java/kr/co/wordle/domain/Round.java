package kr.co.wordle.domain;

import kr.co.wordle.support.InputValidator;
import java.util.Arrays;

import static kr.co.wordle.config.WordleGameConfig.WORD_LENGTH;

public class Round {

    private final int value;

    private final String input;
    private final RoundResult roundResult;

    public Round() {
        this.value = 0;
        this.input = null;
        this.roundResult = new RoundResult();
    }

    private Round(int value, String input) {
        if (InputValidator.isNotValid(input)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.input = input;
        this.roundResult = new RoundResult();
    }

    public Round next(String input) {
        return new Round(value + 1, input);
    }

    public int currentRound() {
        return this.value;
    }

    public String roundResult(Answer answer) {
        char[] inputChars = input.toCharArray();
        int[] countPerCharacter = Arrays.copyOf(answer.getCountPerCharacter(), 26);
        for (int i = 0; i< WORD_LENGTH; i++) {
            Tile key = getTile(countPerCharacter, answer.charAt(i), inputChars[i]);
            roundResult.update(key);
        }
        return roundResult.toString();
    }

    public Tile getTile(int[] counts, char source, char target) {
        if(counts[target - 'a'] == 0) {
            return Tile.GRAY;
        }
        if(source != target) {
            return Tile.YELLOW;
        }
        counts[target - 'a']--;
        return Tile.GREEN;
    }

    public boolean isFinished() {
        return roundResult.isAllGreen();
    }

    public boolean isInProgress(int maxRound) {
        return value < maxRound;
    }
}
