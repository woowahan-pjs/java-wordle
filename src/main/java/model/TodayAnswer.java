package model;

import java.time.LocalDate;
import java.util.List;

public class TodayAnswer {

    private final LocalDate referenceDate;
    private final List<Characters> todayAnswer;

    public TodayAnswer(List<Characters> characters) {
        todayAnswer = characters;
        referenceDate = LocalDate.of(2021, 6, 19);
    }

    public Characters choiceAnswer(LocalDate date) {
        int differentPeriod = Math.toIntExact(date.toEpochDay() - referenceDate.toEpochDay()) % todayAnswer.size();
        return todayAnswer.get(differentPeriod);
    }
}
