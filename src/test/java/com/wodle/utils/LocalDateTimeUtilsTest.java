package com.wodle.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalDateTimeUtilsTest {

    @Test
    public void NormalTimeCompare() {
        //given
        LocalDateTime past = LocalDate.of(2023, 03, 22)
            .atStartOfDay();
        LocalDateTime future = LocalDate.of(2023, 03, 25)
            .atStartOfDay();

        //when
        long betweenDays = LocalDateTimeUtils.getInstance().getBetweenDays(past, future);

        //then
        assertThat(betweenDays).isEqualTo(3);
    }

    @Test
    public void AbnormalTimeCompare() {
        //given
        LocalDateTime future = LocalDate.of(2023, 03, 22)
            .atStartOfDay();
        LocalDateTime past = LocalDate.of(2023, 03, 25)
            .atStartOfDay();

        //when
        long betweenDays = LocalDateTimeUtils.getInstance().getBetweenDays(past, future);

        //then
        assertThat(betweenDays).isEqualTo(-3);
    }

    @Test
    public void nonStartOfDayTest() {
        //given
        LocalDateTime past = LocalDateTime.of(2023, 03, 26, 5, 3);
        LocalDateTime future = LocalDateTime.of(2023, 03, 27, 5, 3);

        //when
        long betweenDays = LocalDateTimeUtils.getInstance().getBetweenDays(past, future);

        //then
        assertThat(betweenDays).isEqualTo(1);
    }
}