package com.wodle.utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class LocalDateTimeUtils {

    private static LocalDateTimeUtils localDateTimeUtils;

    private LocalDateTimeUtils() {
    }

    public static LocalDateTimeUtils getInstance() {
        if (localDateTimeUtils == null) {
            localDateTimeUtils = new LocalDateTimeUtils();
        }

        return localDateTimeUtils;
    }

    public long getBetweenDays(LocalDateTime past, LocalDateTime future) {
        return Duration.between(past, future)
            .toDays();
    }
}
