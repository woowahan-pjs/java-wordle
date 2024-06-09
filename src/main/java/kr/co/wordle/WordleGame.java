package kr.co.wordle;

import java.util.ArrayList;
import java.util.List;

public class WordleGame {

    private static final int MAX_ROUND = 6;
    private final Console console;
    private final Answer answer;
    private final List<RoundResult> roundResults;

    public WordleGame() {
        this.console = new Console();
        this.answer = new Answer();
        this.roundResults = new ArrayList<>();
    }

    public void start() {
        int currentRound = 1;
        console.init();
        while (currentRound <= MAX_ROUND) {
            String input = console.inputView();
            Round round = new Round(input);
            RoundResult roundResult = round.roundResult(answer);
            roundResults.add(roundResult);

            if (roundResult.isAllGreen()) {
                console.printRound(currentRound, MAX_ROUND);
                break;
            }
            console.printResult(roundResults);
            currentRound++;
        }

    }
}
