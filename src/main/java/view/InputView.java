package view;

import java.util.Scanner;

public class InputView {

    private static final String START_MESSAGE = "WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.";
    private static final String TURN_MESSAGE = "정답을 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static void start() {
        System.out.println(START_MESSAGE);
    }

    public static String input () {
        System.out.println(TURN_MESSAGE);
        return SCANNER.nextLine();
    }
}
