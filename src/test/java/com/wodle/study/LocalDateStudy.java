package com.wodle.study;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalDateStudy {

    @Test
    public void localDateStudy() {
        //given
        LocalDateTime base = LocalDate.of(2021, 6, 19)
            .atStartOfDay();
        LocalDateTime target = LocalDate.of(2021, 6, 21)
            .atStartOfDay();

        //when
        long betweenDays = Duration.between(base, target).toDays();

        //then
        Assertions.assertThat(betweenDays).isEqualTo(2);

    }

}
