package domain;

import view.output.OutputView;

import static view.input.InputView.inputPlayerWordle;
import static view.output.OutputView.printInputAnswer;

public class WordleGames {
    private final int START_COUNT = 1;
    private final int END_COUNT = 6;

    private WordleGame wordleGame = new WordleGame();


    public Tiles start(String answer) {
        Tiles tiles = new Tiles();

        int count = START_COUNT;
        do {
            printInputAnswer();

            String input = inputPlayerWordle();
            Wordles answerWordles = new Wordles(answer, input);

            Tile tile = wordleGame.start(answerWordles);
            tiles.addTiles(tile);
            printTiles(tiles, count);

            count++;
        } while (isContinueGame(tiles, count));

        return tiles;
    }

    private void printTiles(Tiles tiles, int count) {
        if (!isContinueGame(tiles, count)) {
            OutputView.printCount(count, END_COUNT);
        }
        OutputView.printTile(tiles);
    }

    private boolean isContinueGame(Tiles tiles, int count) {
        return !tiles.hasAllGreen() && count <= END_COUNT;
    }

}
