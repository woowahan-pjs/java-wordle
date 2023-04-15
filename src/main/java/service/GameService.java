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

    public Words init() {
        InputView.inputStartGame();
        return new Words(WordsGenerator.read(FileConfig.FILE_PATH));
    }

    public List<GameHistory> startGame(Words words) {
        List<GameHistory> gameHistories = new ArrayList<>();
        Answer answer = words.getAnswer(LocalDate.now());

        int count = 0;
        while (isRound(answer, count)) {
            Word inputWord = words.getWord(InputView.inputWord());
            List<Tile> tiles = answer.compare(inputWord);
            gameHistories.add(new GameHistory(tiles));
            print(answer, gameHistories);
            count++;
        }

        return gameHistories;
    }

    private static boolean isRound(Answer answer, int count) {
        return count < InputView.GAME_TOTAL_ROUND && !answer.isSuccess();
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
