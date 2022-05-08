package wordle.output;

import wordle.domain.design.JudgeResultPrinter;
import wordle.domain.vo.JudgeResult;

public class JudgeResultPrinterImpl implements JudgeResultPrinter {
    @Override
    public void execute(JudgeResult result) {
        System.out.println(result);
    }
}
