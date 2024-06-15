package kr.co.wordle;

public class Round {

    private final String input;
    private final RoundResult roundResult;

    public Round(String input) {
        validateInput(input);
        this.input = input;
        this.roundResult = new RoundResult();
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

    public String roundResult(Answer answer) {
        char[] inputChars = input.toCharArray();
        int[] countPerCharacter = answer.countPerCharacter();

        for (int i = 0; i< inputChars.length; i++) {
            if (Tile.GREEN == getTile(answer, i, inputChars[i])) {
                countPerCharacter[inputChars[i] - 'a']--;
            }
        }

        for (int i = 0; i < inputChars.length; i++) {
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
