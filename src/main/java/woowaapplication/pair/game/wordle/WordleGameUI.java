package woowaapplication.pair.game.wordle;

import java.util.List;

import woowaapplication.pair.game.wordle.dto.GameResultDto;

public class WordleGameUI {


    public WordleGameUI() {
    }

    public static void printReady() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.");
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");
    }

    public static void printTerminate() {
        System.out.println("게임이 종료되었습니다.");
    }

    public void printResult(GameResultDto gameResultDto) {
        System.out.println(gameResultDto.getHistory());
        System.out.println(gameResultDto.getChance());
    }

    public static WordleGameUI of() {
        return new WordleGameUI();
    }
}
