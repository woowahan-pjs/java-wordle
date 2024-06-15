package wordle;

import wordle.domain.EpochDayBaseAnswerSelector;
import wordle.domain.WordListFileReader;
import wordle.view.ConsoleInputView;
import wordle.view.ConsoleOutputView;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        final ConsoleInputView inputView = new ConsoleInputView();
        final ConsoleOutputView outputView = new ConsoleOutputView();
        final WordListFileReader answerFileReader = new WordListFileReader();
        final Game game = new Game(inputView, outputView, answerFileReader);
        game.start(new EpochDayBaseAnswerSelector(LocalDate.now()));
    }
}
