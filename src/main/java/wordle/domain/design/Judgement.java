package wordle.domain.design;

import wordle.domain.vo.JudgeResult;
import wordle.domain.vo.UserWord;

public interface Judgement {
    JudgeResult execute(String answer, UserWord input); // 유저 인풋을 판단
}
