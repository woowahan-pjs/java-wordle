package wordle.design;

import wordle.vo.JudgeResult;

public interface Printer {
    void execute(JudgeResult result);
}
