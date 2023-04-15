package ui;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static String inputComment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정답을 입력해 주세요.\n");
        return scanner.nextLine();
    }
}
