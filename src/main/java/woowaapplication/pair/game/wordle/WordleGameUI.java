package woowaapplication.pair.game.wordle;

import java.util.List;

public class WordleGameUI {

    private final WordleGameStorage wordleGameStorage;

    public WordleGameUI(WordleGameStorage wordleGameStorage) {
        this.wordleGameStorage = wordleGameStorage;
    }

    public static void printReady() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.");
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public static void printTerminate() {
        System.out.println("게임이 종료되었습니다.");
    }

    public void printResult(List<String[]> gameResult) {
        if (wordleGameStorage.isClear()) {
            System.out.println(wordleGameStorage.getRestChance() + "/" + WordleGame.TOTAL_CHANCE);
        }

        gameResult.stream()
                .map(array -> String.join(" ", array))
                .forEach(System.out::println);
    }

    public static WordleGameUI of(WordleGameStorage wordleGameStorage) {
        return new WordleGameUI(wordleGameStorage);
    }
}
