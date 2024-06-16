package controller;

import domain.*;
import ui.GuideTextView;
import ui.HintView;
import ui.InputView;
import ui.RoundView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Round round;
    private MatchResults matchResults;
    private Answer answer;

    private List<String> availableWords;

    private GuideTextView guideTextView;
    private InputView inputView;
    private HintView hintView;
    private RoundView roundView;
    private boolean isEndGame = false;

    protected GameManager() {
    }

    public GameManager(List<String> availableWords) {
        this.answer = new Answer(LocalDate.now(), availableWords);
        this.availableWords = availableWords;
        this.round = new Round(6, 1);
        this.matchResults = new MatchResults();
        this.guideTextView = new GuideTextView();
        this.inputView = new InputView();
        this.hintView = new HintView();
        this.roundView = new RoundView();
    }


    public void start() {
        guideTextView.render();
        while(!this.isEndGame && round.isNotFinalRound()) {
            startRound();
        }
    }

    private void startRound() {
        // 라운드 입력 view
        String input = inputView.input();

        InputWord inputWord;
        try {
            inputWord = new InputWord(input, this.availableWords);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        MatchResult matchResultOfInput = answer.match(inputWord);
        this.matchResults.add(matchResultOfInput);

        // 정답 확인
        boolean isEndGame = matchResultOfInput.isEndGame();
        if(isEndGame) {
            roundView.render(round.getCurrent(),round.getLimit());
            this.isEndGame = isEndGame;
        }

        // 힌트 노출
        hintView.render(this.matchResults);
        round.goNext();
    }
}
