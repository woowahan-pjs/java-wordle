package wordle;

import wordle.domain.design.GameManager;
import wordle.domain.design.JudgeResultPrinter;
import wordle.domain.design.Judgement;
import wordle.domain.design.MessagePrinter;
import wordle.domain.design.UserInput;
import wordle.domain.design.WordGenerator;
import wordle.domain.model.GameManagerImpl;
import wordle.domain.model.JudgementImpl;
import wordle.domain.usecase.GameInput;
import wordle.input.UserInputImpl;
import wordle.input.WordGeneratorImpl;
import wordle.output.JudgeResultPrinterImpl;
import wordle.output.MessagePrinterImpl;

public class WordleApplication {

    public static void main(String[] args) {
        GameManager gameManager = init();
        gameManager.start();
    }

    public static GameManager init() {
        UserInput userInput = new UserInputImpl();
        WordGenerator wordGenerator = new WordGeneratorImpl();
        Judgement judgement = new JudgementImpl();
        JudgeResultPrinter judgeResultPrinter = new JudgeResultPrinterImpl();
        MessagePrinter messagePrinter = new MessagePrinterImpl();

        GameInput gameInput = new GameInput(messagePrinter, userInput);
        GameManager gameManager = new GameManagerImpl(gameInput, wordGenerator, judgement, judgeResultPrinter,
                messagePrinter);
        return gameManager;
    }
}
