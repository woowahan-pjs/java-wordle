package wordle.domain;

import java.time.*;
import java.util.List;

public class TimeBaseAnswerSelector implements Selector {

    private static final ZonedDateTime BASE_ZONED_DATE_TIME = ZonedDateTime.of(
            LocalDateTime.of(LocalDate.of(2021, 6, 19), LocalTime.of(0, 0)),
            ZoneId.of("Asia/Seoul"));

    private final ZonedDateTime zonedDateTime;

    public TimeBaseAnswerSelector(final ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public Word select(List<Word> wordList) {



        return new Word("circle");
    }
}