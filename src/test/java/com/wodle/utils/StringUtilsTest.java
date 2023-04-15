package com.wodle.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"aaaaa", "bbbbb", "ccccc", "ddddd"})
    public void normalTest(String source) {
        //when
        boolean result = StringUtils.getInstance().matchesFiveSmallAlphabet(source);

        //then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaa", "bbb", "cc", "d", "Aaaaa", "1aaaa", "ㅁaaaa"})
    public void abNormalTest(String source) {
        //when
        boolean result = StringUtils.getInstance().matchesFiveSmallAlphabet(source);

        //then
        assertThat(result).isFalse();
    }
}