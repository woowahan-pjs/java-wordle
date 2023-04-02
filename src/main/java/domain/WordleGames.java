package domain;

import view.output.OutputView;

import static view.input.InputView.inputPlayerWordle;
import static view.output.OutputView.printInputAnswer;

public class WordleGames {

    private WordleGame wordleGame = new WordleGame();

    public Tiles start(String answer) {
        Tiles tiles = new Tiles();

        int count = 1;
        do {
            printInputAnswer();

            String input = inputPlayerWordle();
            Wordles answerWordles = new Wordles(answer, input);

            Tile tile = wordleGame.start(answerWordles);
            tiles.addTiles(tile);
            OutputView.printTile(tiles);

            count++;
        } while(!tiles.hasAllGreen() && count <= 6);

        return tiles;
    }

}
