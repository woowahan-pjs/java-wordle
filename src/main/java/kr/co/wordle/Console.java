package kr.co.wordle;

import java.util.Scanner;

public class Console {

    public void init() {
        System.out.println("WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.\n");
    }

    public String userInput() {
        System.out.println("정답을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!AnswerProvider.isInputInWords(input)) {
            System.out.println("단어가 아니므로 다시 입력해주세요.");
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
