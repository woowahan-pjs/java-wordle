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
        int[] countPerCharacter = answer.countPerCharacter();

        for (int i = 0; i< WORD_LENGTH; i++) {
            if (Tile.GREEN == getTile(answer, i, inputChars[i])) {
                countPerCharacter[inputChars[i] - 'a']--;
            }
        }

        for (int i = 0; i < WORD_LENGTH; i++) {
            Tile key = getTile(answer, i, inputChars[i]);
            if (key == Tile.YELLOW && countPerCharacter[inputChars[i] - 'a'] == 0) {
                key = Tile.GRAY;
            }
            roundResult.update(key);
        }
        return roundResult.toString();
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

    public boolean isFinished() {
        return roundResult.isAllGreen();
    }
}
