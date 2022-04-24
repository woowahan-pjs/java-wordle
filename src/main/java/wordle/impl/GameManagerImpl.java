package wordle.impl;

import wordle.design.GameManager;
import wordle.design.Judgement;
import wordle.design.UserInput;
import wordle.design.WordGenerator;
import wordle.vo.UserWord;

public class GameManagerImpl implements GameManager {

    private static final String OPENING_PHRASE = "WORDLE을 6번 만에 맞춰 보세요.\n시도의 결과는 타일의 색 변화로 나타납니다.";

    private UserInput userInput;
    private WordGenerator wordGenerator;
    private Judgement judgement;

    public GameManagerImpl() {
        this.userInput = new UserInputImpl();
        this.wordGenerator = new WordGeneratorImpl();
        this.judgement = new JudgementImpl();
    }

    @Override
    public void start() {
        final String answer = wordGenerator.execute();
        System.out.println(OPENING_PHRASE);
        for (int i = 0; i < 6; i++) {
            UserWord userWord = userInput.execute();
        }
    }

    @Override
    public void end() {

    }
}
