package model;

import static org.assertj.core.api.Assertions.assertThat;

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

}