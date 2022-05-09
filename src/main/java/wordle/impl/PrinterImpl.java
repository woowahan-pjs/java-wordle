package wordle.impl;

import wordle.design.Printer;
import wordle.vo.JudgeResult;

public class PrinterImpl implements Printer {
    @Override
    public void execute(JudgeResult result) {
        System.out.println(result);
    }
}
