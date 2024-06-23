package wordle;

import wordle.domain.EpochDayBaseAnswerSelector;
import wordle.domain.WordListFileReader;
import wordle.domain.WordListReader;
import wordle.domain.AnswerSelector;
import wordle.view.ConsoleInputView;
import wordle.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        final ConsoleInputView inputView = new ConsoleInputView();
        final ConsoleOutputView outputView = new ConsoleOutputView();
        final WordListReader wordListReader = new WordListFileReader();
        final AnswerSelector answerSelector = new EpochDayBaseAnswerSelector();
        final Game game = new Game(inputView, outputView, wordListReader, answerSelector);
        game.start();
    }
}
