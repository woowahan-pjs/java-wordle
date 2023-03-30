package com.wodle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import com.wodle.domain.Word;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    private InputManager inputManager;

    @BeforeEach
    public void init() {
        inputManager = new InputManager();
    }


    @Test
    public void normalInputManagerTest() {
        //given
        inputSetting("abcde");

        //when
        Word word = inputManager.inputWord();

        //then
        assertThat(word.getWord()).isEqualTo("abcde");
    }

    @Test
    public void abnormalInputManagerTest() {
        //given
        inputSetting("\nabcde");

        //when && then
        assertThatThrownBy(
            () -> inputManager.inputWord()
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("user input require 5 small alphabet");
    }

    private void inputSetting(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }
}