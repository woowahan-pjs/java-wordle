package controller;

import domain.Answer;
import domain.InputWord;
import domain.MatchResults;
import domain.Round;
import ui.GuideTextView;
import ui.HintView;
import ui.InputView;
import ui.RoundView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Round round;
    private List<MatchResults> matchResults;
    private Answer answer;

    private List<String> availableWords;

    private GuideTextView guideTextView;
    private InputView inputView;
    private HintView hintView;
    private RoundView roundView;

    protected GameManager() {
        this.matchResults = new ArrayList<>();
        this.availableWords = new ArrayList<>();
    }

    public GameManager(List<String> availableWords) {
        this.answer = new Answer(LocalDate.now(), availableWords);
        this.availableWords = availableWords;
        this.round = new Round(6, 1);
        this.matchResults = new ArrayList<>();
        this.guideTextView = new GuideTextView();
        this.inputView = new InputView();
        this.hintView = new HintView();
        this.roundView = new RoundView();
    }


    public void start() {
        guideTextView.render();

        // 라운드 입력 view
        System.out.println(this.answer);
        String input = inputView.input();

        InputWord inputWord = new InputWord(input, this.availableWords);
        MatchResults matchResultOfInput = inputWord.match(answer);
        this.matchResults.add(matchResultOfInput);

        // 정답 확인
        if(matchResultOfInput.isEndGame()) {
            roundView.render(round.getCurrent(),round.getLimit());
        }

        // 힌트 노출
        hintView.render(this.matchResults);




    }
}
