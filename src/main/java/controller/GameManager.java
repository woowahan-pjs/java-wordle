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
    private final static int ROUND_LIMIT = 6;
    private final Round round;
    private final MatchResults matchResults;
    private final Word answer;
    private boolean isWinning;

    private final List<String> availableWords;

    private final GuideTextView guideTextView;
    private final InputView inputView;
    private final HintView hintView;
    private final RoundView roundView;

    public GameManager(List<String> availableWords) {
        this.answer = Word.createAnswer(LocalDate.now(), availableWords);
        this.availableWords = availableWords;
        this.round = new Round(ROUND_LIMIT);
        this.matchResults = new MatchResults();
        this.guideTextView = new GuideTextView();
        this.inputView = new InputView();
        this.hintView = new HintView();
        this.roundView = new RoundView();
    }


    public void start() {
        guideTextView.render(round.getLimit());
        while(isNotWinning() && round.isNotFinalRound()) {
            startRound();
        }
    }

    private void startRound() {
        String input = inputView.input();

        Word inputWord;
        try {
            inputWord = Word.createInput(input, this.availableWords);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        checkAnswer(inputWord);

        if(isWinning()) {
            roundView.render(round.getCurrent(),round.getLimit());
        }

        hintView.render(this.matchResults);
        round.goNext();
    }

    private void checkAnswer(Word inputWord) {
        MatchResult matchResultOfInput = answer.match(inputWord);
        this.matchResults.add(matchResultOfInput);
        setWinning(matchResultOfInput.isWinning());
    }

    private boolean isNotWinning(){
        return !isWinning();
    }

    private boolean isWinning() {
        return isWinning;
    }

    private void setWinning(boolean winning) {
        isWinning = winning;
    }
}
