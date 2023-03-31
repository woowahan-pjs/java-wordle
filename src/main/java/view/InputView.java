package view;

import java.util.Scanner;

public class InputView {

    public static final int GAME_TOTAL_ROUND = 6;

    private static final String INPUT_START_GAME_MESSAGE
            = String.format("WORDLE을 %d번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.", GAME_TOTAL_ROUND);

    private static final String INPUT_WORD_MESSAGE = "정답을 입력해주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static void inputStartGame() {
        System.out.println(INPUT_START_GAME_MESSAGE);
    }

    public static String inputWord() {
        System.out.println(INPUT_WORD_MESSAGE);
        return scanner.nextLine();
    }
}
