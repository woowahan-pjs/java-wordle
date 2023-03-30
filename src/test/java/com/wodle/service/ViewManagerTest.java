package com.wodle.service;

import static com.wodle.domain.TileColor.GREEN;
import static com.wodle.domain.TileColor.GREY;
import static com.wodle.domain.TileColor.YELLOW;
import static org.assertj.core.api.Assertions.assertThat;

import com.wodle.domain.AnswerWord;
import com.wodle.domain.Result;
import com.wodle.domain.TileColor;
import com.wodle.service.ViewManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ViewManagerTest {

    private ViewManager viewManager;

    @BeforeEach
    public void init() {
        viewManager = new ViewManager();
    }


    @Test
    public void FirstResultViewTest() {
        //given
        List<TileColor> tileColors = Arrays.asList(GREEN, GREEN, YELLOW, YELLOW, GREY);
        Result result = new Result(tileColors);

        //when
        OutputStream out = getOutputStream();
        viewManager.printCompareResult(result);

        //then
        assertThat(out.toString()).isEqualTo("\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE8\uD83D\uDFE8⬜\n");
    }

    @Test
    public void SecondResultViewTest() {
        //given
        List<TileColor> tileColors1 = Arrays.asList(GREEN, GREEN, YELLOW, YELLOW, GREY);
        List<TileColor> tileColors2 = Arrays.asList(GREEN, YELLOW, YELLOW, YELLOW, GREY);
        Result result1 = new Result(tileColors1);
        Result result2 = new Result(tileColors2);
        viewManager.printCompareResult(result1);

        //when
        OutputStream out = getOutputStream();
        viewManager.printCompareResult(result2);

        //then
        assertThat(out.toString()).isEqualTo(
            "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE8\uD83D\uDFE8⬜\n\uD83D\uDFE9\uD83D\uDFE8\uD83D\uDFE8\uD83D\uDFE8⬜\n");
    }

    @Test
    public void successResultPrintTest() {
        //given
        boolean isGameEnd = true;
        AnswerWord word = new AnswerWord("happy");

        //when
        OutputStream out = getOutputStream();
        viewManager.printResult(isGameEnd, word);

        //then
        assertThat(out.toString()).isEqualTo(
            "성공 하셨습니다.\n");

    }

    @ParameterizedTest
    @ValueSource(strings = {"happy", "bombs", "honey", "abcde"})
    public void failResultPrintTest(String word) {
        //given
        boolean isGameEnd = false;
        AnswerWord answerWord = new AnswerWord(word);

        //when
        OutputStream out = getOutputStream();
        viewManager.printResult(isGameEnd, answerWord);

        //then
        assertThat(out.toString()).isEqualTo(
            "실패 하셨습니다.\n오늘의 단어 " + answerWord.getWord() + "\n");
    }

    private OutputStream getOutputStream() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }
}