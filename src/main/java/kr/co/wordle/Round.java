package kr.co.wordle;

import static kr.co.wordle.WordleGameConfig.WORD_LENGTH;

public class Round {

    private final String input;
    private final RoundResult roundResult;

    public Round(String input) {
        if (InputValidator.isNotValid(input)) {
            throw new IllegalArgumentException();
        }
        this.input = input;
        this.roundResult = new RoundResult();
    }

    public String roundResult(Answer answer) {
        char[] inputChars = input.toCharArray();
        int[] countPerCharacter = answer.getCountPerCharacter();

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
}
