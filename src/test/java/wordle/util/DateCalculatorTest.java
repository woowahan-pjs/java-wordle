package wordle.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class DateCalculatorTest {
    final LocalDate BASE_DATE = LocalDate.of(2026, 1, 7);
    final LocalDate COMPARISON_DATE = LocalDate.of(2026, 1, 8);

    @Test
    void 입력받은_날짜와_현재날짜의_차이를_반환() {
        long days = DateCalculator.calculate(BASE_DATE, COMPARISON_DATE);

        assertThat(days).isEqualTo(1);
    }
}