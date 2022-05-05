package controller;

import domain.Game;
import domain.GameStatus;
import domain.WordPool;
import view.InputView;
import view.ResultView;

public class Wordle {

    private final InputView inputView;
    private final ResultView resultView;

    public Wordle(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {

        inputView.startView();
        final Game game = Game.start(new WordPool());

        do {
            playingGame(game);
        } while (game.isNotFinish());
    }

    private void playingGame(final Game game) {
        try {
            final GameStatus gameStatus = game.playGame(inputView.inputWord());
            resultView.view(gameStatus, game.getGameResult());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
