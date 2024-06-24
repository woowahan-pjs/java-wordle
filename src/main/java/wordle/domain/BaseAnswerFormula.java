package wordle.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import wordle.exception.AnswerFormulaException;

public class BaseAnswerFormula implements AnswerFormula {

    private static final LocalDate BASE = LocalDate.of(2021, 6, 19);
    private static final int MIN_WORD_COUNT = 1;

    public int calculate(int wordCount) {
        if (wordCount < MIN_WORD_COUNT) {
            throw new AnswerFormulaException();
        }

        return (int) ChronoUnit.DAYS.between(BASE, LocalDate.now()) % wordCount;
    }
}
