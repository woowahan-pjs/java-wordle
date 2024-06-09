package kr.co.wordle;

public class WordleGame {

    private static final int MAX_ROUND = 6;
    private final Console console;
    private final Answer answer;

    public WordleGame() {
        this.console = new Console();
        this.answer = new Answer();
    }

    public void start() {
        int currentRound = 1;
        console.init();
        while (currentRound <= MAX_ROUND) {
            String input = console.inputView();
            Round round = new Round(input);
            RoundResult result = round.roundResult(answer);
            console.printResult(result);

            if (result.isAllGreen()) {
                console.printRound(currentRound, MAX_ROUND);
                break;
            }

            currentRound++;
        }

    }
}
