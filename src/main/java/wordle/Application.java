package wordle;

import wordle.domain.EpochDayBaseAnswerSelector;
import wordle.domain.WordListFileReader;
import wordle.view.ConsoleInputView;
import wordle.view.ConsoleOutputView;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();
        ConsoleOutputView outputView = new ConsoleOutputView();
        WordListFileReader answerFileReader = new WordListFileReader();
        Game game = new Game(inputView, outputView, answerFileReader);
        game.start(new EpochDayBaseAnswerSelector(LocalDate.now()));
    }
}
