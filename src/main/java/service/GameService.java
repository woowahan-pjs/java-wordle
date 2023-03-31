package service;

import config.FileConfig;
import domain.Answer;
import domain.Tile;
import domain.Word;
import domain.Words;
import dto.GameHistory;
import support.WordsGenerator;
import view.InputView;
import view.OutputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    public Answer init() {
        InputView.inputStartGame();
        Words words = new Words(WordsGenerator.read(FileConfig.FILE_PATH));
        return words.getAnswer(LocalDate.now());
    }

    public List<GameHistory> startGame(Answer answer) {
        List<GameHistory> gameHistories = new ArrayList<>();

        int count = 0;
        while (count < InputView.GAME_TOTAL_ROUND && !answer.isSuccess()) {
            Word inputWord = new Word(InputView.inputWord());
            List<Tile> tiles = answer.compare(inputWord);
            gameHistories.add(new GameHistory(tiles));
            print(answer, gameHistories);
            count++;
        }

        return gameHistories;
    }

    private void print(Answer answer, List<GameHistory> gameHistories) {
        if (!answer.isSuccess()) {
            OutputView.outputTiles(gameHistories);
        }
    }

    public void endGame(List<GameHistory> gameHistories) {
        OutputView.outputEndGame(gameHistories);
    }
}
