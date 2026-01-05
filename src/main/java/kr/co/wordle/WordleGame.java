package kr.co.wordle;

import kr.co.wordle.domain.Answer;
import kr.co.wordle.domain.Round;
import kr.co.wordle.view.Console;

import static kr.co.wordle.config.WordleGameConfig.MAX_ROUND;

public class WordleGame {
    private final Console console;
    private final Answer answer;
    private final StringBuilder roundResults;

    public WordleGame() {
        this.console = new Console();
        this.answer = new Answer();
        this.roundResults = new StringBuilder();
    }

    public void start() {
        console.init();
        Round round = new Round();
        while (isRoundInProgress(round, roundResults)) {
            String input = console.userInput();
            round = round.next(input);
            roundResults.append(round.roundResult(answer)).append("\n");
            console.printRoundResult(roundResults);
        }
    }

    private boolean isRoundInProgress(Round round, StringBuilder roundResults) {
        if (round == null) {
            return true;
        }
        if (round.isFinished()) {
            console.printRound(round.currentRound(), MAX_ROUND);
            console.printRoundResult(roundResults);
            return false;
        }
        return round.isInProgress(MAX_ROUND);
    }
}
