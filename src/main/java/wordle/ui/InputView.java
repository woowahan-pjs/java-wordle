package wordle.ui;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputUsersWord() {
        try {
            return scanner.nextLine()
                .replace(" ", "")
                .trim();
        } catch (Exception e) {
            throw new IllegalArgumentException("입력된 문자열을 읽는 중에 에러가 발생했습니다.");
        }
    }
}
