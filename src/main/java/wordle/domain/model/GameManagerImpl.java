package wordle.domain.model;


import wordle.domain.design.GameManager;
import wordle.domain.design.JudgeResultPrinter;
import wordle.domain.design.Judgement;
import wordle.domain.design.MessagePrinter;
import wordle.domain.design.WordGenerator;
import wordle.domain.usecase.GameInput;
import wordle.domain.vo.JudgeResult;
import wordle.domain.vo.Message;
import wordle.domain.vo.UserWord;

public class GameManagerImpl implements GameManager {

    private static final int PROGRESS_COUNT = 6;

    private GameInput gameInput;
    private WordGenerator wordGenerator;
    private Judgement judgement;
    private JudgeResultPrinter judgeResultPrinter;
    private MessagePrinter messagePrinter;

    public GameManagerImpl(GameInput gameInput, WordGenerator wordGenerator, Judgement judgement,
                           JudgeResultPrinter judgeResultPrinter, MessagePrinter messagePrinter) {
        this.gameInput = gameInput;
        this.wordGenerator = wordGenerator;
        this.judgement = judgement;
        this.judgeResultPrinter = judgeResultPrinter;
        this.messagePrinter = messagePrinter;
    }

    @Override
    public void start() {
        final String answer = wordGenerator.execute();
        messagePrinter.execute(Message.GAME_START);
        boolean gameContinue = true;
        for (int i = 0; gameContinue && i < PROGRESS_COUNT; i++) {
            UserWord userWord = gameInput.execute();
            JudgeResult judgeResult = judgement.execute(answer, userWord);
            judgeResultPrinter.execute(judgeResult);
            gameContinue = judgeResult.continueGame();
        }
        if (gameContinue) {
            messagePrinter.execute(Message.FAIL_END);
            end();
            return;
        }
        messagePrinter.execute(Message.SUCCESS_END);
        end();
    }

    @Override
    public void end() {
        messagePrinter.execute(Message.GAME_END_INSTRUCTION);
        gameInput.end();
    }
}
