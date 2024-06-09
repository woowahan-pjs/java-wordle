package kr.co.wordle;

import java.util.List;
import java.util.Scanner;

public class Console {

    public void init() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.\n");
    }

    public String inputView() {
        System.out.println("정답을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void printResult(List<RoundResult> roundResults) {
        for (RoundResult result : roundResults) {
            System.out.println(result);
        }
    }

    public void printRound(int currentRound, int maxRound) {
        System.out.printf("%d/%d", currentRound, maxRound);
    }
}
