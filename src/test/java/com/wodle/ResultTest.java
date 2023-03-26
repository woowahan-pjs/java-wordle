package com.wodle;

import static com.wodle.domain.TileColor.GREEN;
import static org.assertj.core.api.Assertions.assertThat;

import com.wodle.domain.TileColor;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultTest {

    @Test
    public void GameEndTest() {
        //given
        List<TileColor> matchStatus = Arrays.asList(GREEN, GREEN, GREEN, GREEN, GREEN);
        Result result = new Result(matchStatus);

        //when
        boolean isGameEnd = result.isGameEnd();

        assertThat(isGameEnd).isTrue();
    }

    @ParameterizedTest
    @CsvSource(
        value = {
            "GREEN, GREEN, GREEN, GREEN, YELLOW",
            "GREEN,GREEN,GREEN,YELLOW,YELLOW",
            "GREEN,GREEN,YELLOW,GREY,YELLOW",
            "GREEN,GREEN,GREEN,GREEN,GREY",
            "GREEN,GREY,YELLOW,GREY,YELLOW"
        }, delimiter = ','
    )
    public void GameNotEndTest(String r1, String r2, String r3, String r4, String r5) {
        //given
        List<TileColor> matchStatus = Arrays.asList(
            TileColor.valueOf(r1),
            TileColor.valueOf(r2),
            TileColor.valueOf(r3),
            TileColor.valueOf(r4),
            TileColor.valueOf(r5)
        );
        Result result = new Result(matchStatus);

        //when
        boolean isGameEnd = result.isGameEnd();

        assertThat(isGameEnd).isFalse();
    }
}
