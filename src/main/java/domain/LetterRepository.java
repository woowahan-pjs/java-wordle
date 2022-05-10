package domain;

import java.time.LocalDate;

public interface LetterRepository {
    Letters getTodayAnswer(LocalDate localDate);
    boolean isContains(Letters userAnswer);
}
