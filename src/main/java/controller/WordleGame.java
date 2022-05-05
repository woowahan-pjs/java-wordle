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
        int currentTurn = getCurrentTurn(answer, resultsList);
        OutputView.turnOutput(currentTurn, resultsList);
    }

    private int getCurrentTurn(Characters answer, List<Results> resultsList) {
        int currentTurn = 0;
        while (!turn.isGameOver()) {
            currentTurn = turn.increase();
            Characters inputCharacters = new Characters(InputView.input());
            Results match = inputCharacters.match(answer);
            resultsList.add(match);
            if (match.isMatch() || turn.isGameOver()) {
                break;
            }
            OutputView.output(resultsList);
        }
        return currentTurn;
    }
}
