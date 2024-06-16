package kr.co.wordle.view;

import kr.co.wordle.support.InputValidator;
import java.util.Scanner;

import static kr.co.wordle.config.WordleGameConfig.MAX_ROUND;

public class Console {

    public void init() {
        System.out.println("WORDLE을 " + MAX_ROUND + "번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.\n");
    }

    public String userInput() {
        System.out.println("정답을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (InputValidator.isNotValid(input)) {
            System.out.println("다시 입력해주세요.");
            input = sc.nextLine();
        }
        return input;
    }

    public void printRoundResult(StringBuilder roundResults) {
        System.out.println(roundResults);
    }

    public void printRound(int currentRound, int maxRound) {
        System.out.printf("%d/%d%n", currentRound, maxRound);
    }
}
