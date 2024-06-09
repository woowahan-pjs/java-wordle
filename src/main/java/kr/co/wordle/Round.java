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

    public RoundResult roundResult(Answer answer) {
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            Tile key = getTile(answer, i, inputChars[i]);
            roundResult.update(key);

        }
        return roundResult;
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
