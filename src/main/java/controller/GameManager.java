package controller;

import domain.MatchResults;
import domain.Round;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Round round;
    private List<MatchResults> matchResults;
    public GameManager() {
        this.matchResults = new ArrayList<>();
    }


}
