package wordle.domain;

import java.time.LocalDate;
import java.util.List;

public class EpochDayBaseAnswerSelector implements WordSelector {
    private static final LocalDate BASE_LOCAL_DATE = LocalDate.of(2021, 6, 19);
    private final long epochDay;

    public EpochDayBaseAnswerSelector(final long epochDay) {
        this.epochDay = epochDay;
    }

    public EpochDayBaseAnswerSelector(final LocalDate localDate) {
        this(localDate.toEpochDay());
    }

    @Override
    public Word select(final List<Word> wordList) {
        final long baseEpochDay = BASE_LOCAL_DATE.toEpochDay();
        final long timeDifference = Math.subtractExact(epochDay, baseEpochDay);
        if (timeDifference < 0) {
            throw new RuntimeException();
        }
        return wordList.get((int) timeDifference % wordList.size());
    }
}
