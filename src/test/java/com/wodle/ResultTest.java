package com.wodle;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultTest {

    @Test
    public void GameEndTest() {
        //given
        List<Integer> matchStatus =  Arrays.asList(2,2,2,2,2);
        Result result = new Result(matchStatus);

        //when
        boolean isGameEnd = result.isGameEnd();

        assertThat(isGameEnd).isTrue();
    }

    @ParameterizedTest
    @CsvSource(
        value = {
            "2,2,2,2,1",
            "2,2,2,1,1",
            "2,2,1,0,1",
            "2,2,2,2,0",
            "2,0,1,0,1"
        }, delimiter = ','
    )
    public void GameNotEndTest(int r1, int r2, int r3, int r4 ,int r5) {
        //given
        List<Integer> matchStatus =  Arrays.asList(r1, r2, r3, r4, r5);
        Result result = new Result(matchStatus);

        //when
        boolean isGameEnd = result.isGameEnd();

        assertThat(isGameEnd).isFalse();
    }
}
