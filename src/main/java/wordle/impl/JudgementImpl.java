package wordle.impl;

import wordle.design.Judgement;
import wordle.vo.JudgeResult;

public class JudgementImpl implements Judgement {
    @Override
    public JudgeResult execute(String answer, String input) {
        return JudgeResult.BAD;
    }
}
