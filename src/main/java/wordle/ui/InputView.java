package wordle.ui;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputUsersWord() {
        return scanner.nextLine()
                .replace(" ", "")
                .trim();
    }
}
