package wordle.domain;

import java.time.*;

public class EpochDayBaseAnswerSelector implements Selector {

    private static final LocalDate BASE_LOCAL_DATE = LocalDate.of(2021, 6, 19);
    private final LocalDate localDate;

    public EpochDayBaseAnswerSelector(final LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public Word select(final WordList wordList) {
        final long epochDay = localDate.toEpochDay();
        final long baseEpochDay = BASE_LOCAL_DATE.toEpochDay();
        final long timeDifference = Math.subtractExact(epochDay, baseEpochDay);
        if (timeDifference < 0) {
            throw new RuntimeException();
        }
        return wordList.get(timeDifference % wordList.size());
    }
}