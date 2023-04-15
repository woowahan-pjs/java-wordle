package com.wodle.testUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import com.wodle.utils.FileUtils;
import java.util.stream.Stream;
import org.mockito.MockedStatic;

public interface FileMockUtils {

    FileUtils fileUtils = mock(FileUtils.class);
    MockedStatic<FileUtils> fileUtilsMockStatic  = mockStatic(FileUtils.class);

    default void fileMockUtilsInit() {
        fileUtilsMockStatic.when(FileUtils::getInstance).thenReturn(fileUtils);
    }

    default void mockingFileUtilsGetStreamByFileName(String... args) {
        when(fileUtils.getStreamByFileName(any()))
            .thenReturn(Stream.of(args));
    }

    default void mockingFileUtilsGetStreamByFileNameThrow(Throwable e) {
        when(fileUtils.getStreamByFileName(any()))
            .thenThrow(e);
    }
}
