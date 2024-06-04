package woowaapplication.pair.game.wordle;

import java.util.List;
import java.util.Scanner;

public class WordleGameUI {

    private final WordleGameStorage wordleGameStorage;
    private final Scanner sc;

    public WordleGameUI(WordleGameStorage wordleGameStorage, Scanner sc) {
        this.wordleGameStorage = wordleGameStorage;
        this.sc = sc;
    }

    public static void printReady() {
        printMessage("WORDLE을 6번 만에 맞춰 보세요.");
        printMessage("시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public static void printTerminate() {
        printMessage("게임이 종료되었습니다.");
    }

    public String getInputKeyword() {
        return sc.nextLine();
    }

    public void printResult(List<String[]> gameResult) {
        if (wordleGameStorage.isClear()) {
            printMessage(wordleGameStorage.getRestChance() + "/" + WordleGame.TOTAL_CHANCE);
        }

        gameResult.stream()
                .map(array -> String.join(" ", array))
                .forEach(WordleGameUI::printMessage);
    }

    public static WordleGameUI of(WordleGameStorage wordleGameStorage, Scanner sc) {
        return new WordleGameUI(wordleGameStorage, sc);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
