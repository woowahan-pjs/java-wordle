package wordle.study;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import wordle.TimeTestSupporter;

public class TimeTest {

    private static final LocalDate mockedDate = LocalDate.of(2024, 6, 12);

    // test(Time): LocalDate 모킹 유틸 추가
    @Test
    void LocalDate를_mocking_할_수_있다() {
        TimeTestSupporter.runWithMock(mockedDate, () -> {
            LocalDate now = LocalDate.now();
            LocalDate base = LocalDate.of(2021, 6, 19);

            long ans = ChronoUnit.DAYS.between(base, now);

            Assertions.assertThat(ans).isEqualTo(1089);
        });
    }
}
