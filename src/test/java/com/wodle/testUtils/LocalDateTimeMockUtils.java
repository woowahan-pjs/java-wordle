package com.wodle.testUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import com.wodle.utils.LocalDateTimeUtils;
import org.mockito.MockedStatic;

public interface LocalDateTimeMockUtils {

    LocalDateTimeUtils localDateTimeUtils = mock(LocalDateTimeUtils.class);
    MockedStatic<LocalDateTimeUtils> localDateTimeMockUtilsStatic = mockStatic(
        LocalDateTimeUtils.class);

    default void localDateTimeMockUtilsInit() {
        localDateTimeMockUtilsStatic.when(LocalDateTimeUtils::getInstance)
            .thenReturn(localDateTimeUtils);
    }
    default void mockingLocalDateTimeUtilsGetBetweenDays(long returnValue) {
        when(localDateTimeUtils.getBetweenDays(any(), any()))
            .thenReturn(returnValue);
    }
}
