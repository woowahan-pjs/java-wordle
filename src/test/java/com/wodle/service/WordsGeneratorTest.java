package com.wodle.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import com.wodle.domain.Word;
import com.wodle.service.WordsGenerator;
import com.wodle.utils.FileUtils;
import com.wodle.utils.LocalDateTimeUtils;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class WordsGeneratorTest {

    private WordsGenerator wordsGenerator;
    private MockedStatic<LocalDateTimeUtils> localDateTimeUtilsMockedStatic;
    private MockedStatic<FileUtils> fileUtilsMockedStatic;

    @BeforeEach
    public void init() {
        localDateTimeUtilsMockedStatic = mockStatic(
            LocalDateTimeUtils.class);
        fileUtilsMockedStatic = mockStatic(FileUtils.class);

        wordsGenerator = new WordsGenerator();
    }

    @AfterEach
    public void destroy() {
        localDateTimeUtilsMockedStatic.close();
        fileUtilsMockedStatic.close();
    }

    @Test
    public void todayWordsTest() {
        //given
        when(LocalDateTimeUtils.getBetweenDays(any(), any()))
            .thenReturn(3L);
        when(FileUtils.getStreamByFileName(any()))
            .thenReturn(Stream.of("aaaaa",
                "bbbbb",
                "ccccc",
                "ddddd",
                "eeeee"));

        //when
        Word todayWord = wordsGenerator.getTodayWord();

        //then
        assertThat(todayWord.getWord()).isEqualTo("ddddd");
    }

    @Test
    public void fileNotFoundTodayWordsTest() {
        //given
        when(LocalDateTimeUtils.getBetweenDays(any(), any()))
            .thenReturn(3L);
        when(FileUtils.getStreamByFileName(any()))
            .thenThrow(new IllegalArgumentException("File not found"));

        //when

        //then
        assertThatThrownBy(
            () -> wordsGenerator.getTodayWord()
        ).isInstanceOf(RuntimeException.class)
            .hasMessage("단어를 셋팅할수 없습니다");

    }

}