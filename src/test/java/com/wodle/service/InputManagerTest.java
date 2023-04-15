package com.wodle.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.wodle.domain.Word;
import com.wodle.testUtils.SystemInOutUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputManagerTest implements SystemInOutUtils {

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
}