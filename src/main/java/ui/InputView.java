package ui;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    public String input() {
        System.out.println("정답을 입력해 주세요.");

        return scanner.nextLine();
    }

}
