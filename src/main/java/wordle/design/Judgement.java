package wordle.design;

import wordle.vo.JudgeResult;

public interface Judgement {
    JudgeResult execute(String answer, String input); // 유저 인풋을 판단
}
