package controller;

import domain.Answer;
import dto.GameHistory;
import service.GameService;

import java.util.List;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        Answer answer = gameService.init();
        List<GameHistory> gameHistories = gameService.startGame(answer);
        gameService.endGame(gameHistories);
    }
}
