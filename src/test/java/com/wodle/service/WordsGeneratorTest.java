package com.wodle.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.wodle.domain.Word;
import com.wodle.testUtils.FileMockUtils;
import com.wodle.testUtils.LocalDateTimeMockUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsGeneratorTest implements FileMockUtils, LocalDateTimeMockUtils {

    private WordsGenerator wordsGenerator;

    @BeforeEach
    public void init() {
        fileMockUtilsInit();
        localDateTimeMockUtilsInit();

        wordsGenerator = new WordsGenerator();
    }


    @Test
    public void todayWordsTest() {
        //given
        mockingLocalDateTimeUtilsGetBetweenDays(3L);
        mockingFileUtilsGetStreamByFileName("aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee");

        //when
        Word todayWord = wordsGenerator.getTodayWord();

        //then
        assertThat(todayWord.getWord()).isEqualTo("ddddd");
    }

    @Test
    public void fileNotFoundTodayWordsTest() {
        //given
        mockingLocalDateTimeUtilsGetBetweenDays(3L);
        mockingFileUtilsGetStreamByFileNameThrow(new IllegalArgumentException("File Not Found"));

        //then
        assertThatThrownBy(
            () -> wordsGenerator.getTodayWord()
        ).isInstanceOf(RuntimeException.class)
            .hasMessage("can not setting word");

    }

}