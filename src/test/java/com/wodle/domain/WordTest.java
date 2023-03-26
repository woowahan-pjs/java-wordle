package com.wodle.domain;

import static com.wodle.domain.TileColor.GREEN;
import static com.wodle.domain.TileColor.GREY;
import static com.wodle.domain.TileColor.YELLOW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.wodle.Result;
import java.util.List;
import org.junit.jupiter.api.Test;

class WordTest {

    @Test
    public void NormalWordCreateTest() {
        //given
        Word word = new Word("abcde");

        //when
        String wordStr = word.getWord();
        char[] wordArr = word.getWordArray();

        //then
        assertAll(
            () -> assertThat(wordStr).isEqualTo("abcde"),
            () -> assertThat(wordArr).containsExactly('a', 'b', 'c', 'd', 'e')
        );
    }

    @Test
    public void AbnormalWordCreateTest() {
        assertThatThrownBy(
            () -> new Word("abcd2")
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("user input require 5 small alphabet");
    }

    @Test
    public void NormalAnswerWordCreateTest() {
        //given
        AnswerWord word = new AnswerWord("abcde");

        //when
        String wordStr = word.getWord();
        char[] wordArr = word.getWordArray();

        //then
        assertAll(
            () -> assertThat(wordStr).isEqualTo("abcde"),
            () -> assertThat(wordArr).containsExactly('a', 'b', 'c', 'd', 'e')
        );
    }

    @Test
    public void AbnormalAnswerWordCreateTest() {
        assertThatThrownBy(
            () -> new AnswerWord("abcd2")
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("user input require 5 small alphabet");
    }

    @Test
    public void AnswerWordCompareTest() {
        //given
        AnswerWord source = new AnswerWord("abcde");
        Word target = new Word("bdnce");

        //when
        Result result = source.compare(target);
        List<TileColor> colors = result.getMatchStatus();

        //then
        assertAll(
            () -> assertThat(result.isGameEnd()).isFalse(),
            () -> assertThat(colors).containsExactly(YELLOW, YELLOW, GREY, YELLOW, GREEN)
        );
    }
}