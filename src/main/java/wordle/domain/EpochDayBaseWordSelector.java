package wordle.domain;

import java.time.LocalDate;
import java.util.List;

public class EpochDayBaseWordSelector implements WordSelector {
    private static final LocalDate BASE_LOCAL_DATE = LocalDate.of(2021, 6, 19);

    @Override
    public Word select(final List<? extends Word> wordList) {
        final LocalDate now = LocalDate.now();
        final long nowEpochDay = now.toEpochDay();
        final long baseEpochDay = BASE_LOCAL_DATE.toEpochDay();
        final long timeDifference = Math.subtractExact(nowEpochDay, baseEpochDay);
        if (timeDifference < 0) {
            throw new RuntimeException("시간 차이가 음수로 나와서 단어를 선택할 수 없습니다");
        }
        return wordList.get((int) timeDifference % wordList.size());
    }
}
