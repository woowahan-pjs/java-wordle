package wordle;

import wordle.application.Wordle;
import wordle.domain.FileWordBook;
import wordle.domain.WordBook;
import wordle.infra.FileReader;
import wordle.ui.ConsoleInputView;
import wordle.ui.ConsoleOutputView;
import wordle.ui.InputView;
import wordle.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        WordBook wordBook = new FileWordBook(new FileReader());
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        Wordle wordle = new Wordle(wordBook, inputView, outputView);
        wordle.startGame();
    }
}
