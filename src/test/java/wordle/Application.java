package wordle;

import wordle.Game;
import wordle.domain.WordListFileReader;
import wordle.view.ConsoleInputView;
import wordle.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();
        ConsoleOutputView outputView = new ConsoleOutputView();
        WordListFileReader answerFileReader = new WordListFileReader();
        Game game = new Game(inputView, outputView, answerFileReader);
        game.start();
    }
}
