package wordle;

import wordle.domain.design.GameManager;
import wordle.domain.design.JudgeResultPrinter;
import wordle.domain.design.Judgement;
import wordle.domain.design.MessagePrinter;
import wordle.domain.design.UserInput;
import wordle.domain.design.WordGenerator;
import wordle.domain.impl.GameManagerImpl;
import wordle.domain.impl.JudgementImpl;
import wordle.in.UserInputImpl;
import wordle.in.WordGeneratorImpl;
import wordle.out.JudgeResultPrinterImpl;
import wordle.out.MessagePrinterImpl;

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
        GameManager gameManager = new GameManagerImpl(userInput, wordGenerator, judgement, judgeResultPrinter,
                messagePrinter);
        return gameManager;
    }
}
