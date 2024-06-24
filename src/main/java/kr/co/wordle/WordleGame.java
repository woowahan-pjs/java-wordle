package kr.co.wordle;

import kr.co.wordle.domain.Answer;
import kr.co.wordle.domain.Round;
import kr.co.wordle.view.Console;

import static kr.co.wordle.config.WordleGameConfig.MAX_ROUND;

public class WordleGame {
    private final Console console;
    private final Answer answer;
    private final StringBuilder roundResults;

    private int currentRound;

    public WordleGame() {
        this.console = new Console();
        this.answer = new Answer();
        this.roundResults = new StringBuilder();
        this.currentRound = 0;
    }

    public void start() {
        console.init();
        Round round = null;
        while (isRoundInProgress(round, roundResults)) {
            currentRound++;
            String input = console.userInput();
            round = new Round(input);
            roundResults.append(round.roundResult(answer)).append("\n");
            console.printRoundResult(roundResults);
        }
    }

    private boolean isRoundInProgress(Round round, StringBuilder roundResults) {
        if (round == null) {
            return true;
        }
        if (round.isFinished()) {
            console.printRound(currentRound, MAX_ROUND);
            console.printRoundResult(roundResults);
            return false;
        }
        return currentRound < MAX_ROUND;
    }
}
