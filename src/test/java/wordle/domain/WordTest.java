package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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


    @DisplayName("정답과 답안의 일치여부를 검사한다.")
    @ParameterizedTest(name = "문제 {0}, 답 {1}, 결과 {2}")
    @MethodSource("sample")
    void wordCompareTest(String question, String answer, List<Result> expected) {
        Word sourceWord = new Word(question);
        Word targetWord = new Word(answer);

        List<Result> results = sourceWord.compare(targetWord);

        assertThat(results).isEqualTo(expected);
    }

    public static Stream<Arguments> sample() {
        return Stream.of(
                Arguments.of("spill", "hello", List.of(Result.WRONG, Result.WRONG, Result.HALF_CORRECT, Result.CORRECT, Result.WRONG)),
                Arguments.of("spill", "label", List.of(Result.HALF_CORRECT, Result.WRONG, Result.WRONG, Result.WRONG, Result.CORRECT)),
                Arguments.of("spill", "spell", List.of(Result.CORRECT, Result.CORRECT, Result.WRONG, Result.CORRECT, Result.CORRECT)),
                Arguments.of("spill", "spill", List.of(Result.CORRECT, Result.CORRECT, Result.CORRECT, Result.CORRECT, Result.CORRECT))
        );
    }

}
