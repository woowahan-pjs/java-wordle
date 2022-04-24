package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @Test
    void test() {
        //        사용자가 제출한 Words와 비교하여 WordsMatchResult를 반환한다.
        final Words happy = new Words("happy");
        final Answer answer = new Answer(happy);
        final WordsMatchResult matchResult = answer.matches(happy);

        assertThat(answer.matches(happy)).isNotNull();

    }


    @Test
    void matches성공_5개모두일치함() {
        final String input = "happy";
        final Answer answer = new Answer(new Words(input));
        final Words words = new Words(input);

        final WordsMatchResult matches = answer.matches(words);
        assertThat(matches.isCorrect()).isTrue();
    }

    @Test
    void matches성공_모두일치하지않음() {
        final String input = "happy";
        final Answer answer = new Answer(new Words(input));
        final Words words = new Words("hasdf");

        final WordsMatchResult matches = answer.matches(words);
        assertThat(matches.isCorrect()).isFalse();
    }

}