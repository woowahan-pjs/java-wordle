package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TurnTest {

    @DisplayName("한 턴을 진행 했을때 횟수 증가 확인")
    @Test
    void increaseTurn() {
        Turn turn = new Turn();

        int result = turn.increase();

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("턴이 6회 초과 증가시 예외발생")
    @Test
    void TurnException() {
        Turn turn = new Turn(6);

        assertThatThrownBy(() -> {
            turn.increase();
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("6번까지 입력 가능합니다.");
    }
}