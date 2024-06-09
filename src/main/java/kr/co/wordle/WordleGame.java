package kr.co.wordle;

import java.util.Map;

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
            Map<Tile, Integer> result = round.roundResult(answer);

            if (result.getOrDefault(Tile.GREEN, 0) == 5) {
                System.out.printf("%d/%d", currentRound, MAX_ROUND);
                break;
            }
            System.out.println("다시");

            currentRound++;
        }

    }
}
