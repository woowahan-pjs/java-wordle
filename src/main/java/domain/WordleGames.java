package domain;

import java.util.List;

import static view.input.InputView.inputPlayerWordle;
import static view.output.OutputView.printInputAnswer;

public class WordleGames {

    private WordleGame wordleGame = new WordleGame();

    public WordleGames() {

    }

    public Tiles start(String answer) {
        // answer -> char
        Tiles tiles = new Tiles();

        int count = 1;
        do {
            printInputAnswer();

            String input = inputPlayerWordle();
            Wordles answerWordles = new Wordles(answer, input);

            // 단어 입력
            Tile tile = wordleGame.start(answerWordles);

            tiles.addTiles(tile);

            // 전부다 그린일경우 -> 게임 종료
            List<TileColor> tileColors = tile.getTileColors();

            boolean allGreen = true;

            for (int i = 0; i < tileColors.size(); i++) {
                if (!tileColors.get(i).equals(TileColor.GREEN)) {
                    allGreen = false;
                    break;
                }
            }

            if (allGreen) {
                return tiles;
            }
            count++;
        } while(count <= 6);

        return tiles;
    }

}
