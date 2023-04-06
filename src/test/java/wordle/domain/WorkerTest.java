package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WorkerTest {

    @Test
    @DisplayName("선택된 정답은 words에 포함되어 있어야한다.")
    void questionShouldContainsInWords() {
        List<Word> words = List.of(
                new Word("asdfg"),
                new Word("zxcvb"),
                new Word("qwert")
        );
        Worker worker = new Worker(words, size -> 0);

        Word question = worker.proposeQuestion();

        assertThat(question).isEqualTo(new Word("asdfg"));
    }

    @Test
    @DisplayName("워커에 의해 선택된 정답은 Words에 포함되어있는 경우 True를 반환한다.")
    void test() {
        List<Word> words = List.of(
                new Word("asdfq"),
                new Word("poiue"),
                new Word("zxcvb")
        );
        String inputAnswer = "poiue";

        Worker worker = new Worker(words, size -> 1);
        boolean check = worker.isAnswerEmbedded(new Word(inputAnswer));
        assertThat(check).isTrue();
    }
}