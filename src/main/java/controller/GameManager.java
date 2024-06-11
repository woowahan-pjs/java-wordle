package controller;

import domain.Answer;
import domain.MatchResults;
import domain.Round;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Round round;
    private List<MatchResults> matchResults;
    private Answer answer;
    public GameManager() {
        this.matchResults = new ArrayList<>();
    }

    public GameManager(List<String> wordList) {
        this.round = new Round(5, 0);       // 총 6번과 시작은 항상 0
        this.matchResults = new ArrayList<>();
        this.answer = Answer.from(wordList);
    }

    public void startGame() {

    }


}
