package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WordTest {

    @Test
    @DisplayName("Word의 길이는 5를 초과한 경우 실패합니다.")
    void wordLengthShouldEqualTo5() {
        assertThatThrownBy(() -> new Word("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Word의 길이는 5 미만인 경우 실패합니다.")
    void wordLengthLessThan5ShouldFail() {
        assertThatThrownBy(() -> new Word("abcd")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void wordToStringTest() {

        Word word = new Word("abcde");

        assertThat(word.castWordsToString()).isEqualTo("abcde");
    }

    @Test
    @DisplayName("정답과 답안의 일치여부를 검사한다.")
    void wordCompareTest() {
        Word sourceWord = new Word("asdfg");
        Word targetWord = new Word("qwefg");

        List<Result> results = sourceWord.compare(targetWord);

        assertThat(results).isEqualTo(List.of(Result.WRONG, Result.WRONG, Result.WRONG, Result.CORRECT, Result.CORRECT));
    }
}
