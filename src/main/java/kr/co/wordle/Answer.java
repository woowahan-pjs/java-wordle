package kr.co.wordle;

public class Answer {

    private final String value;

    public Answer() {
        this.value = AnswerProvider.todayAnswer();
    }

    public void roundResult(String input) {
        char[] answerChars = value.toCharArray();
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < answerChars.length; i++) {
            System.out.println(getTile(answerChars[i], inputChars[i]));
        }
    }

    public Tile getTile(char source, char target) {
        if (source == target) {
            return Tile.GREEN;
        }
        if (value.indexOf(target) > -1) {
            return Tile.YELLOW;
        }
        return Tile.GRAY;
    }
}
