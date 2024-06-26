package controller;

import domain.MatchResult;
import domain.GameState;
import domain.Round;
import domain.Word;
import ui.*;

import java.time.LocalDate;
import java.util.List;

public class GameManager {
    private final GameState state;
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
        this.state = new GameState();
        this.guideTextView = new GuideTextView();
        this.inputView = new InputView();
        this.hintView = new HintView();
        this.roundView = new RoundView();
        this.answerView = new AnswerView();
    }

    public void start() {
        guideTextView.render(Round.ROUND_LIMIT);
        while(state.shouldContinueGame()) {
            startRound();
        }
        if(state.isNotWinning()) {
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
            roundView.render(state.currentRound(), Round.ROUND_LIMIT);
        }
        state.add(matchResult);

        hintView.render(state);
    }
}
