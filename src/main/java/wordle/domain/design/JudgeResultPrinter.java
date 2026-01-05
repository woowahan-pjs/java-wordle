package wordle.domain.design;

import wordle.domain.vo.JudgeResult;

public interface JudgeResultPrinter {
    void execute(JudgeResult result);
}
