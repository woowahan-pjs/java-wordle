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
        Word inputWord = null;
        boolean canCreateInputWord = false;

        while (!canCreateInputWord) {
            String input = inputView.input();
            inputWord = Word.createInput(input, this.availableWords);
            canCreateInputWord = inputWord.getAvailableWord();
        }

        checkAnswer(inputWord);
        renderResult();
        round.goNext();
    }

    private void renderResult() {
        checkRenderRound();
        hintView.render(matchResults);
        checkFinalRound();
    }

    private void checkRenderRound() {
        if(this.isWinning || !round.isNotFinalRound()) {
            roundView.render(round.getCurrent(),round.getLimit());
        }
    }

    private void checkFinalRound() {
        if(!this.isWinning && round.isFinalRound()) {
            roundView.render(round.getCurrent(),round.getLimit());
            roundView.renderLoseGame();;
        }
    }


    private void checkAnswer(Word inputWord) {
        MatchResult matchResultOfInput = answer.match(inputWord);
        this.matchResults.add(matchResultOfInput);
        this.isWinning = matchResultOfInput.isEndGame();
    }

}
