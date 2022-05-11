package wordle.app.bucket.domain;

import org.junit.jupiter.api.Test;
import wordle.app.word.domain.Answer;
import wordle.app.word.domain.Words;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FileWordsBucketTest {

    private static final String filePath = "src/test/resources/words.txt";
    private static final String words = "rebut";

    @Test
    void WordsBucket생성() {
        final FileWordsBucket wordsBucket = new FileWordsBucket(filePath, LocalDate.of(2021, 6, 19));

        assertThat(wordsBucket.contains(new Words(words))).isTrue();
    }

    @Test
    void WordsBucket생성실패() {
        assertThatThrownBy(() -> new FileWordsBucket("must/fail/test/only.txt", LocalDate.of(2021, 6, 19)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정답을_결정한다() {
        final LocalDate today = LocalDate.of(2021, 6, 20);
        final FileWordsBucket wordsBucket = new FileWordsBucket(filePath, LocalDate.of(2021, 6, 19));
        final Answer answer = wordsBucket.findAnswer(today);

        assertThat(answer).isNotNull();
        assertThat(answer.matches(new Words(words)).isCorrect()).isTrue();
    }

    @Test
    void contains가True() {
        final FileWordsBucket wordsBucket = new FileWordsBucket(filePath, LocalDate.of(2021, 6, 19));

        assertThat(wordsBucket.contains(new Words(words))).isTrue();
    }

    @Test
    void contains가False() {
        final FileWordsBucket wordsBucket = new FileWordsBucket(filePath, LocalDate.of(2021, 6, 19));

        assertThat(wordsBucket.contains(new Words("cigam"))).isFalse();
    }

}
