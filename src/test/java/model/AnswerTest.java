package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

    @DisplayName("정답은 5글자 여야 한다.")
    @Test
    void answerLengthValid() {
        Answer answer = Answer.create("abcde");

        assertThat(answer).isNotNull();
        assertThat(answer.length()).isEqualTo(5);
    }

    @DisplayName("정답 문자열의 길이가 5글자가 아닌 경우, 예외처리")
    @Test
    void answerLengthNotFiveException() {
        assertThatThrownBy(() -> Answer.create("abce"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Answer.create("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}