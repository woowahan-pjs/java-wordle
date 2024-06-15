package wordle.view;

import wordle.domain.Word;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private final Scanner scanner;

    public ConsoleInputView() {
        this(new Scanner(System.in));
    }

    public ConsoleInputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Word inputWord() {
        return new Word(scanner.nextLine());
    }
}