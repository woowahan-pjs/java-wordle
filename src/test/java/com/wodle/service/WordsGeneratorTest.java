package com.wodle.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.wodle.domain.Word;
import com.wodle.testUtils.StaticMockingUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordsGeneratorTest extends StaticMockingUtils {

    private WordsGenerator wordsGenerator;

    @BeforeEach
    public void init() {
        super.init();

        wordsGenerator = new WordsGenerator();
    }

    @AfterEach
    public void destroy() {
        super.destroy();
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
            .hasMessage("단어를 셋팅할수 없습니다");

    }

}