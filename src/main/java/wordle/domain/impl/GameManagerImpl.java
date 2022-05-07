package wordle.domain.impl;

import wordle.domain.design.GameManager;
import wordle.domain.design.JudgeResultPrinter;
import wordle.domain.design.Judgement;
import wordle.domain.design.MessagePrinter;
import wordle.domain.design.UserInput;
import wordle.domain.design.WordGenerator;
import wordle.domain.vo.JudgeResult;
import wordle.domain.vo.Message;
import wordle.domain.vo.UserWord;

public class GameManagerImpl implements GameManager {

    private static final String OPENING_PHRASE = "WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.";
    private static final int PROGRESS_COUNT = 6;

    private UserInput userInput;
    private WordGenerator wordGenerator;
    private Judgement judgement;
    private JudgeResultPrinter printer;
    private MessagePrinter messagePrinter;

    public GameManagerImpl(UserInput userInput, WordGenerator wordGenerator, Judgement judgement, JudgeResultPrinter printer, MessagePrinter messagePrinter) {
        this.userInput = userInput;
        this.wordGenerator = wordGenerator;
        this.judgement = judgement;
        this.printer = printer;
        this.messagePrinter = messagePrinter;
    }

    @Override
    public void start() {
        final String answer = wordGenerator.execute();
        System.out.println(OPENING_PHRASE);
        for (int i = 0; i < PROGRESS_COUNT; i++) {
            UserWord userWord = userInput.execute();
            JudgeResult judgeResult = judgement.execute(answer, userWord.getValue());
            printer.execute(judgeResult);
            if (judgeResult.isEndAble()) { // Todo indent 2 맞추기
                end();
                messagePrinter.execute(Message.SUCCESS_END);
                return;
            }
        }
    }

    @Override
    public void end() {
        userInput.end();
    }
}
