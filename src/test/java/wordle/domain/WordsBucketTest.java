package wordle.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WordsBucketTest {

    private static final String filePath = "src/test/resources/words.txt";
    private static final String words = "rebut";

    @Test
    void WordsBucket생성() {
        final WordsBucket wordsBucket = new WordsBucket(filePath);

        assertThat(wordsBucket.contains(new Words(words))).isTrue();
    }

    @Test
    void WordsBucket생성실패() {
        assertThatThrownBy(() -> new WordsBucket("must/fail/test/only.txt"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정답을_결정한다() {
        final LocalDate today = LocalDate.of(2021, 6, 20);
        final WordsBucket wordsBucket = new WordsBucket(filePath);
        final Answer answer = wordsBucket.findAnswer(today);

        assertThat(answer).isNotNull();
        assertThat(answer.matches(new Words(words)).isCorrect()).isTrue();
    }

    @Test
    void contains가True() {
        final WordsBucket wordsBucket = new WordsBucket(filePath);

        assertThat(wordsBucket.contains(new Words(words))).isTrue();
    }

    @Test
    void contains가False() {
        final WordsBucket wordsBucket = new WordsBucket(filePath);

        assertThat(wordsBucket.contains(new Words("cigam"))).isFalse();
    }

}
