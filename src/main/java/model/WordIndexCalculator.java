package model;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class WordIndexCalculator {

    private final long workbookSize;
    private final LocalDateTime startDate;
    private final Clock clock;

    public WordIndexCalculator(long wordbookSize, LocalDateTime startDate, Clock clock) {
        this.workbookSize = wordbookSize;
        this.startDate = startDate;
        this.clock = clock;
    }

    public long getTodayWordIndex() {
        LocalDateTime now = LocalDateTime.now(clock);
        long daysBetween = ChronoUnit.DAYS.between(startDate, now);
        return daysBetween % workbookSize;
    }
}
