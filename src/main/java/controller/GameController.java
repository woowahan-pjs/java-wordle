package controller;

import domain.Answer;
import domain.Words;
import dto.GameHistory;
import service.GameService;

import java.time.LocalDate;
import java.util.List;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        Words words = gameService.init();
        List<GameHistory> gameHistories = gameService.startGame(words);
        gameService.endGame(gameHistories);
    }
}
