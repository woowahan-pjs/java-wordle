package wordle.domain.generator;

import java.time.LocalDate;
import java.time.Month;

public class DefaultGenerator implements IndexGenerator {
    public int get(int size) {
        long todayToEpochDay = LocalDate.now().toEpochDay();
        long standardDateToEpochDay = LocalDate.of(2021, Month.JUNE, 19).toEpochDay();
        return (int) ((todayToEpochDay - standardDateToEpochDay) % size);
    }
}
