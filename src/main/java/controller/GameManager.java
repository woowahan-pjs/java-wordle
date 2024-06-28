package controller;

import domain.MatchResult;
import domain.MatchResults;
import domain.Round;
import domain.Word;
import ui.GuideTextView;
import ui.HintView;
import ui.InputView;
import ui.RoundView;

import java.time.LocalDate;
import java.util.List;

public class GameManager {
    private Round round;
    private MatchResults matchResults;
    private Word answer;

    private List<String> availableWords;

    private GuideTextView guideTextView;
    private InputView inputView;
    private HintView hintView;
    private RoundView roundView;
    private boolean isWinning = false;

    protected GameManager() {
    }

    public GameManager(List<String> availableWords) {
        this.answer = Word.createAnswer(LocalDate.now(), availableWords);
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
        while(!this.isWinning && round.isNotFinalRound()) {
            startRound();
        }
    }

    private void startRound() {
        // 라운드 입력 view
        String input = inputView.input();

        Word inputWord;
        try {
            inputWord = Word.createInput(input, this.availableWords);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        checkAnswer(inputWord);

        if(this.isWinning) {
            roundView.render(round.getCurrent(),round.getLimit());
        }

        hintView.render(this.matchResults);
        round.goNext();
    }

    private void checkAnswer(Word inputWord) {
        MatchResult matchResultOfInput = answer.match(inputWord);
        this.matchResults.add(matchResultOfInput);
        this.isWinning = matchResultOfInput.isEndGame();
    }

}
