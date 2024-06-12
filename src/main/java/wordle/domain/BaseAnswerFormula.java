package wordle.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BaseAnswerFormula implements AnswerFormula {

    private final static LocalDate BASE = LocalDate.of(2021, 6, 19);

    public long calculate(int wordCount) {
        return ChronoUnit.DAYS.between(BASE, LocalDate.now()) % wordCount;
    }
}
