package wordle.domain;

import wordle.domain.ConsoleInputView;
import wordle.domain.Game;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();
        ConsoleOutputView outputView = new ConsoleOutputView();
        AnswerFileReader answerFileReader = new AnswerFileReader();
        Game game = new Game(inputView, outputView, answerFileReader);
        game.start();
    }
}
