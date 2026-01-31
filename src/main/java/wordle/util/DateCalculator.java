package wordle.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateCalculator {
    public static long calculate(final LocalDate baseDate, final LocalDate comparisonDate) {
        return ChronoUnit.DAYS.between(baseDate, comparisonDate);
    }
}
