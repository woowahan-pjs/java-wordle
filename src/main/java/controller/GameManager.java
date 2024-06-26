package controller;

import domain.MatchResult;
import domain.MatchResults;
import domain.Round;
import domain.Word;
import ui.*;

import java.time.LocalDate;
import java.util.List;

public class GameManager {
    private final MatchResults matchResults;
    private final Word answer;
    private final List<String> availableWords;
    private final GuideTextView guideTextView;
    private final InputView inputView;
    private final HintView hintView;
    private final RoundView roundView;
    private final AnswerView answerView;

    public GameManager(List<String> availableWords) {
        this.answer = Word.createAnswer(LocalDate.now(), availableWords);
        this.availableWords = availableWords;
        this.matchResults = new MatchResults();
        this.guideTextView = new GuideTextView();
        this.inputView = new InputView();
        this.hintView = new HintView();
        this.roundView = new RoundView();
        this.answerView = new AnswerView();
    }

    public void start() {
        guideTextView.render(Round.ROUND_LIMIT);
        while(matchResults.shouldContinueGame()) {
            startRound();
        }
        if(matchResults.isNotWinning()) {
            answerView.render(answer);
        }
    }

    private void startRound() {
        String input = inputView.input();

        Word inputWord;
        try {
            inputWord = Word.createInput(input, availableWords);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        MatchResult matchResult = answer.match(inputWord);
        if(matchResult.isWinning()) {
            roundView.render(matchResults.currentRound(), Round.ROUND_LIMIT);
        }
        matchResults.add(matchResult);

        hintView.render(matchResults);
    }
}
