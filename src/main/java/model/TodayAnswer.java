package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TodayAnswer {

    private static final LocalDate referenceDate = LocalDate.of(2021, 6, 19);
    private final List<Characters> todayAnswer;

    public TodayAnswer(List<Characters> characters) {
        todayAnswer = characters;
    }

    public Characters choiceAnswer(LocalDate date) {
        int differentPeriod = Math.toIntExact(ChronoUnit.DAYS.between(referenceDate, date)) % todayAnswer.size();
        return todayAnswer.get(differentPeriod);
    }
}
