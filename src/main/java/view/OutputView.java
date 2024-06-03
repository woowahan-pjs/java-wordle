package view;

import dto.GameHistory;

import java.util.List;

public class OutputView {

    public static void outputTiles(List<GameHistory> gameHistories) {
        gameHistories.forEach(gameHistory -> System.out.println(gameHistory.getGameResult()));
        System.out.println();
    }

    public static void outputEndGame(List<GameHistory> gameHistories) {
        System.out.println(gameHistories.size() + "/" + InputView.GAME_TOTAL_ROUND);
        outputTiles(gameHistories);
    }
}
