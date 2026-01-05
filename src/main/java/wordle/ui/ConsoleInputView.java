package wordle.ui;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private final Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String input() {
        return scanner.nextLine();
    }
}
