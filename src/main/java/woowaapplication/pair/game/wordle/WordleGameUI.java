package woowaapplication.pair.game.wordle;

import java.util.List;

public class WordleGameUI {

    private final WordleGameStorage wordleGameStorage;

    public WordleGameUI(WordleGameStorage wordleGameStorage) {
        this.wordleGameStorage = wordleGameStorage;
    }


    public void printResult(List<String[]> 게임_결과) {
        if (wordleGameStorage.isClear()) {
            System.out.println(wordleGameStorage.getRestChance() + "/" + WordleGame.TOTAL_CHANCE);
        }

        게임_결과.stream()
                .map(array -> String.join(" ", array))
                .forEach(System.out::println);
    }
}
