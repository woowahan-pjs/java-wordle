package wordle.impl;

import java.util.ArrayList;
import java.util.List;
import wordle.design.Printer;
import wordle.vo.JudgeResult;

public class PrinterImpl implements Printer {

    private static final List<String> HISTORY = new ArrayList<>();

    @Override
    public void execute(JudgeResult judgeResult) {
        HISTORY.add(judgeResult.toString());
        HISTORY.forEach(System.out::println);
    }
}
