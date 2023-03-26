package com.wodle;

import static com.wodle.domain.TileColor.GREEN;
import static com.wodle.domain.TileColor.GREY;
import static com.wodle.domain.TileColor.YELLOW;
import static org.assertj.core.api.Assertions.assertThat;

import com.wodle.domain.TileColor;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        viewManager.printResult(result);

        //then
        assertThat(out.toString()).isEqualTo("GREEN GREEN YELLOW YELLOW GREY \n");
    }

    @Test
    public void SecondResultViewTest() {
        //given
        List<TileColor> tileColors1 = Arrays.asList(GREEN, GREEN, YELLOW, YELLOW, GREY);
        List<TileColor> tileColors2 = Arrays.asList(GREEN, YELLOW, YELLOW, YELLOW, GREY);
        Result result1 = new Result(tileColors1);
        Result result2 = new Result(tileColors2);
        viewManager.printResult(result1);

        //when
        OutputStream out = getOutputStream();
        viewManager.printResult(result2);

        //then
        assertThat(out.toString()).isEqualTo(
            "GREEN GREEN YELLOW YELLOW GREY \nGREEN YELLOW YELLOW YELLOW GREY \n");
    }

    private OutputStream getOutputStream() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }
}