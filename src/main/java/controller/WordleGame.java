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
    private final List<Results> resultsList;

    public WordleGame() {
        this.turn = new Turn();
        this.todayAnswer = new TodayAnswer(AnswerGroupProvider.provide());
        this.resultsList = new ArrayList<>();
    }

    public void play() {
        InputView.start();
        Characters answer = todayAnswer.choiceAnswer(LocalDate.now());
        do {
            Characters input = inputCharacters();
            Results match = match(answer,input);
            resultsList.add(match);
            if (isGameOver(match)) {
                break;
            }
            OutputView.output(resultsList);
        }while(true);
        OutputView.turnOutput(turn.getTurn(), resultsList);
    }

    private boolean isGameOver(Results match) {
        return match.isMatch() || turn.isGameOver();
    }

    private Characters inputCharacters() {
        return new Characters(InputView.input());
    }

    private Results match(Characters answer, Characters input) {
        turn.increase();
        return input.match(answer);
    }
}
