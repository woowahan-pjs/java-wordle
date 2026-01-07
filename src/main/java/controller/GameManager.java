package controller;

import domain.*;
import ui.*;

import java.time.LocalDate;
import java.util.List;

public class GameManager {
    private final GameState state;
    private final GuideTextView guideTextView;
    private final InputView inputView;
    private final HintView hintView;
    private final RoundView roundView;
    private final AnswerView answerView;
    private final WordDictionary wordDictionary;

    public GameManager(List<String> wordStringList) {
        this.wordDictionary = new WordDictionary(wordStringList);
        this.state = new GameState();
        this.guideTextView = new GuideTextView();
        this.inputView = new InputView();
        this.hintView = new HintView();
        this.roundView = new RoundView();
        this.answerView = new AnswerView();
    }

    public void start() {
        Word answer = wordDictionary.answerWord(LocalDate.now());
        guideTextView.render(Round.ROUND_LIMIT);
        while (state.shouldContinueGame()) {
            startRound(answer);
        }
        if (state.isNotWinning()) {
            answerView.render(answer);
        }
    }

    private void startRound(Word answer) {
        String input = inputView.input();
        Word inputWord;
        try {
            inputWord = new Word(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (wordDictionary.hasNot(inputWord)) {
            System.out.println("사전에 없는 단어입니다.");
            return;
        }

        MatchResult matchResult = answer.match(inputWord);
        if (matchResult.isWinning()) {
            roundView.render(state.currentRound(), Round.ROUND_LIMIT);
        }
        state.add(matchResult);

        hintView.render(state);
    }
}
