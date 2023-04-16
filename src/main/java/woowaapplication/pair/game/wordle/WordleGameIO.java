package woowaapplication.pair.game.wordle;

import java.util.Scanner;

import woowaapplication.pair.game.wordle.dto.GameResultDto;

public class WordleGameIO {


    public WordleGameIO() {
    }

    public static void printReady() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.");
        System.out.println("시도의 결과는 타일의 색 변화로 나타납니다.");

    }

    public static String printInputKeyword() {
        System.out.println("5글자의 단어를 입력해주세요.");

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void printTerminate() {
        System.out.println("게임이 종료되었습니다.");
    }

    public void printResult(GameResultDto gameResultDto) {
        System.out.println(gameResultDto.getHistory());

        if (gameResultDto.isClear()) {
            System.out.println(gameResultDto.getChance());
        }
    }

    public static WordleGameIO of() {
        return new WordleGameIO();
    }
}
