package controller;

import config.FileConfig;
import domain.Answer;
import domain.Tile;
import domain.Word;
import domain.Words;
import dto.GameHistory;
import service.GameService;
import support.WordsGenerator;
import view.InputView;
import view.OutputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final GameService gameService;

    private final List<GameHistory> gameHistories = new ArrayList<>();

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void start() {
        Words words = new Words(WordsGenerator.read(FileConfig.FILE_PATH));
        Answer answer = words.getAnswer(LocalDate.now());
        InputView.inputStartGame(); // heart
        for (int i = 0; i < InputView.GAME_TOTAL_ROUND; i++) {
            Word inputWord = new Word(InputView.inputWord());
            System.out.println("answer: " + answer);
            System.out.println("inputWord: " + inputWord);
            List<Tile> tiles = answer.compare(inputWord);
            gameHistories.add(new GameHistory(tiles));
            if (answer.isSuccess() || InputView.GAME_TOTAL_ROUND == i) {
                break;
            }
            OutputView.outputTiles(gameHistories);
        }
        OutputView.outputEndGame(gameHistories);
    }
}
