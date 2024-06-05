package com.wodle.study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CharArrayTest {

    @Test
    public void CharArraySettingTest() {
        //given
        String word = "abcd";
        char[] wordChars = word.toCharArray();

        //when
        wordChars[3] = 'a';

        //then
        assertThat(word).isEqualTo("abcd");
    }

}
