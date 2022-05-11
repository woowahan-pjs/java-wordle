package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Characters;
import model.Results;
import model.TodayAnswer;
import model.Turn;
import util.AnswerGroupProvider;
import view.InputView;
import view.OutputView;

public class WordleGame {

    private static final int TURN_INIT = 0;
    private final Turn turn;
    private final TodayAnswer todayAnswer;

    public WordleGame() {
        this.turn = new Turn();
        this.todayAnswer = new TodayAnswer(AnswerGroupProvider.provide());
    }

    public void play() {
        InputView.start();
        Characters answer = todayAnswer.choiceAnswer(LocalDate.now());
        List<Results> resultsList = new ArrayList<>();
        getCurrentTurn(answer, resultsList);
        int currentTurn = turn.getValue();
        OutputView.turnOutput(currentTurn, resultsList);
    }

    private void getCurrentTurn(Characters answer, List<Results> resultsList) {
        while (!turn.isGameOver()) {
            turn.increase();
            String input = InputView.input();
            Characters inputCharacters = new Characters(input);
            Results match = inputCharacters.match(answer);
            resultsList.add(match);
            if (match.isMatch() || turn.isGameOver()) {
                break;
            }
            OutputView.output(resultsList);
        }
    }
}
