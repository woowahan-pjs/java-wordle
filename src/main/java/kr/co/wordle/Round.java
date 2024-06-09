package kr.co.wordle;

public class Round {

    private final String input;

    public Round(String input) {
        this.input = input;
    }

    public void roundResult(Answer answer) {
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            System.out.println(getTile(answer, i, inputChars[i]));
        }
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
