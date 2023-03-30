package com.wodle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import com.wodle.utils.FileUtils;
import com.wodle.utils.LocalDateTimeUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class GameHostTest {

    private MockedStatic<LocalDateTimeUtils> localDateTimeUtilsMockedStatic;
    private MockedStatic<FileUtils> fileUtilsMockedStatic;
    private GameHost gameHost;

    @BeforeEach
    public void init() {
        localDateTimeUtilsMockedStatic = mockStatic(
            LocalDateTimeUtils.class);
        fileUtilsMockedStatic = mockStatic(FileUtils.class);

        gameHost = new GameHost(
            new InputManager(),
            new ViewManager(),
            new WordsGenerator()
        );
    }

    @AfterEach
    public void destroy() {
        localDateTimeUtilsMockedStatic.close();
        fileUtilsMockedStatic.close();
    }

    @Test
    public void 게임하기정상동작() {
        //given
        when(LocalDateTimeUtils.getBetweenDays(any(), any()))
            .thenReturn(3L);
        when(FileUtils.getStreamByFileName(any()))
            .thenReturn(Stream.of("aaaaa",
                "bbbbb",
                "ccccc",
                "hello",
                "eeeee"));

        //when
        inputSetting("pwiee\niejdf\nhello");
        OutputStream out = getOutputStream();
        gameHost.play();

        //then
        assertThat(out.toString()).contains(
            "성공 하셨습니다.\n");
    }

    @Test
    public void 게임하기비정상동작() {
        //given
        when(LocalDateTimeUtils.getBetweenDays(any(), any()))
            .thenReturn(3L);
        when(FileUtils.getStreamByFileName(any()))
            .thenReturn(Stream.of("aaaaa",
                "bbbbb",
                "ccccc",
                "hello",
                "eeeee"));

        //when
        inputSetting("pwiee\niejdf\neknJe\n32233\nhtioe\nfnsd\neffgr\nffnnh\ncgdeg");
        OutputStream out = getOutputStream();
        gameHost.play();

        //then
        assertThat(out.toString()).contains(
            "실패 하셨습니다.\n오늘의 단어 hello\n");
    }

    private void inputSetting(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }

    private OutputStream getOutputStream() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }
}