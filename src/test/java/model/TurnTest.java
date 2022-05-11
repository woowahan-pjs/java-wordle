package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TurnTest {

    @DisplayName("한 턴을 진행 했을때 횟수 증가 확인")
    @Test
    void increaseTurn() {
        Turn turn = new Turn();

        int result = turn.increase();

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("턴이 6회 초과 증가시 예외발생")
    @Test
    void TurnException() {
        Turn turn = new Turn(6);

        assertThatThrownBy(() -> turn.increase())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("6번까지 입력 가능합니다.");
    }

    @ParameterizedTest(name = "턴이 {0}이면 게임 종료 결과는 {1}")
    @CsvSource({"5,false", "6,true"})
    void isGameOver(int value, boolean result) {
        Turn turn = new Turn(value);

        boolean isGameOver = turn.isGameOver();

        assertThat(isGameOver).isEqualTo(result);
    }
}