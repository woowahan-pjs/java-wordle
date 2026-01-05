package kr.co.wordle.domain;

import kr.co.wordle.support.InputValidator;

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

    protected Round(String input) {
        this(0, input);
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
        int[] countPerCharacter = countGreen(answer, inputChars);
        for (int i = 0; i < WORD_LENGTH; i++) {
            Tile key = getTile(countPerCharacter, answer.charAt(i), inputChars[i]);
            roundResult.update(key);
        }
        return roundResult.toString();
    }

    private int[] countGreen(Answer answer, char[] inputChars) {
        int[] countPerCharacter = answer.getCountPerCharacter();
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (answer.charAt(i) == inputChars[i]) {
                countPerCharacter[inputChars[i] - 'a']--;
            }
        }
        return countPerCharacter;
    }

    public Tile getTile(int[] counts, char source, char target) {
        if (source == target) {
            return Tile.GREEN;
        }
        if (counts[target - 'a'] > 0) {
            return Tile.YELLOW;
        }
        return Tile.GRAY;
    }

    public boolean isFinished() {
        return roundResult.isAllGreen();
    }

    public boolean isInProgress(int maxRound) {
        return value < maxRound;
    }
}
