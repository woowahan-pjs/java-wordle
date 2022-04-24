package test.wordle.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WordsBucketTest {

    @Test
    void WordsBucket생성() {
        final WordsBucket wordsBucket = new WordsBucket("src/main/resources/words.txt");

        assertThat(wordsBucket.size()).isNotZero();
    }

    @Test
    void WordsBucket생성실패() {
        assertThatThrownBy(() -> new WordsBucket("src/main/resources/error.txt"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정답을_결정한다() {
        final LocalDate today = LocalDate.of(2021, 6, 20);
        final WordsBucket wordsBucket = new WordsBucket("src/test/resources/words.txt");
        final Answer answer = wordsBucket.findAnswer(today);

        assertThat(answer).isNotNull();
        assertThat(answer.matches(new Words("rebut")).isCorrect()).isTrue();
    }

}
