package wordle.impl;

import java.util.ArrayList;
import java.util.List;
import wordle.design.GameManager;
import wordle.design.Judgement;
import wordle.design.Printer;
import wordle.design.UserInput;
import wordle.design.WordGenerator;
import wordle.vo.JudgeResult;
import wordle.vo.UserWord;

public class GameManagerImpl implements GameManager {

  private static final String OPENING_PHRASE = "WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.";
  private static final String CLOSING_PHRASE = "정답입니다 짝짝짝";
  private static final int PROGRESS_COUNT = 6;

  private UserInput userInput;
  private WordGenerator wordGenerator;
  private Judgement judgement;
  private Printer printer;

  public GameManagerImpl() {
    this.userInput = new UserInputImpl();
    this.wordGenerator = new WordGeneratorImpl();
    this.judgement = new JudgementImpl();
    this.printer = new PrinterImpl();
  }

  @Override
  public void start() {
    final String answer = wordGenerator.execute();
    System.out.println(OPENING_PHRASE);
    for (int i = 0; i < PROGRESS_COUNT; i++) {
      UserWord userWord = userInput.execute();
      JudgeResult judgeResult = judgement.execute(answer, userWord.getValue());
      printer.execute(judgeResult);
      if (judgeResult.isEndAble()) {
        end();
        return;
      }
    }
  }

  @Override
  public void end() {
    System.out.println(CLOSING_PHRASE);
  }
}
