package kr.co.wordle;

public class WordleGame {

    private static final int MAX_ROUND = 6;
    private final Console console;
    private final Answer answer;
    private final StringBuilder roundResults;

    public WordleGame() {
        this.console = new Console();
        this.answer = new Answer();
        this.roundResults = new StringBuilder();
    }

    public void start() {
        int currentRound = 1;
        console.init();
        while (currentRound <= MAX_ROUND) {
            String input = console.inputView();
            Round round = new Round(input);
            roundResults.append(round.roundResult(answer)).append("\n");

            if (round.isSuccess()) {
                console.printRound(currentRound, MAX_ROUND);
                console.printResult(roundResults);
                break;
            }

            console.printResult(roundResults);
            currentRound++;
        }
    }
}
