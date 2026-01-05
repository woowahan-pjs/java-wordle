package com.wodle.testUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import com.wodle.utils.FileUtils;
import com.wodle.utils.LocalDateTimeUtils;
import java.util.stream.Stream;
import org.mockito.MockedStatic;

public abstract class StaticMockingUtils {
    protected MockedStatic<LocalDateTimeUtils> localDateTimeUtilsMockedStatic;
    protected MockedStatic<FileUtils> fileUtilsMockedStatic;

    protected void init(){
        localDateTimeUtilsMockedStatic = mockStatic(
            LocalDateTimeUtils.class);
        fileUtilsMockedStatic = mockStatic(FileUtils.class);
    }

    protected void destroy() {
        localDateTimeUtilsMockedStatic.close();
        fileUtilsMockedStatic.close();
    }

    protected void mockingLocalDateTimeUtilsGetBetweenDays(long returnValue) {
        when(LocalDateTimeUtils.getBetweenDays(any(), any()))
            .thenReturn(returnValue);
    }

    
    protected void mockingFileUtilsGetStreamByFileName(String... args) {
        when(FileUtils.getStreamByFileName(any()))
            .thenReturn(Stream.of(args));
    }

    protected void mockingFileUtilsGetStreamByFileNameThrow(Throwable e) {
        when(FileUtils.getStreamByFileName(any()))
            .thenThrow(e);
    }
}
