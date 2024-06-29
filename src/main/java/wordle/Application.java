package wordle;

import wordle.domain.DictionaryFileReader;
import wordle.domain.DictionaryReader;
import wordle.domain.EpochDayBaseWordSelector;
import wordle.domain.WordSelector;
import wordle.view.ConsoleInputView;
import wordle.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        final ConsoleInputView inputView = new ConsoleInputView();
        final ConsoleOutputView outputView = new ConsoleOutputView();
        final DictionaryReader dictionaryReader = new DictionaryFileReader();
        final WordSelector wordSelector = new EpochDayBaseWordSelector();
        final Game game = new Game(inputView, outputView, dictionaryReader, wordSelector);
        game.start();
    }
}
