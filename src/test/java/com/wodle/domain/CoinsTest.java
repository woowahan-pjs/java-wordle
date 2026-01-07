package com.wodle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoinsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    public void NormalCoinInitTest(int availableCoin) {
        assertDoesNotThrow(
            () -> new Coins(availableCoin)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5})
    public void AbnormalCoinInitTest(int availableCoin) {
        assertThatThrownBy(
                () -> new Coins(availableCoin)
            ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Coin can be set under 0");
    }

    @Test
    public void CoinUseTest() {
        //given
        Coins coins = new Coins(6);

        //when
        coins.use();
        coins.use();

        //then
        assertThat(coins.isEmpty()).isFalse();
    }

    @Test
    public void CoinEmptyTest() {
        //given
        Coins coins = new Coins(2);

        //when
        coins.use();
        coins.use();

        //then
        assertThat(coins.isEmpty()).isTrue();
    }

    @Test
    public void InvalidCoinUseTest (){
        //given
        Coins coins = new Coins(2);

        //when
        coins.use();
        coins.use();

        //then
        assertThatThrownBy(
            () -> coins.use()
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Coin can be set under 0");
    }
}
