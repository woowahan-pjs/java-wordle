package wordle;

import wordle.domain.EpochDayBaseAnswerSelector;
import wordle.domain.DictionaryFileReader;
import wordle.domain.DictionaryReader;
import wordle.domain.AnswerSelector;
import wordle.view.ConsoleInputView;
import wordle.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        final ConsoleInputView inputView = new ConsoleInputView();
        final ConsoleOutputView outputView = new ConsoleOutputView();
        final DictionaryReader dictionaryReader = new DictionaryFileReader();
        final AnswerSelector answerSelector = new EpochDayBaseAnswerSelector();
        final Game game = new Game(inputView, outputView, dictionaryReader, answerSelector);
        game.start();
    }
}
