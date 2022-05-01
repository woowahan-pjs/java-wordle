package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {
    @DisplayName(" Answer는 제출된 단어를 비교 할 수 있다")
    @Test
    void compare_5green() {
        Letters todayAnswer = Letters.of("abcde");
        Answer answer = new Answer(todayAnswer);
        Letters userAnswer = Letters.of("abcde");

        assertThat(answer.compare(userAnswer).getList()).containsOnly(LetterResult.GREEN);
    }
}
