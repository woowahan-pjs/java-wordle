package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {
    @DisplayName(" Answer는 제출된 단어를 비교 할 수 있다")
    @Test
    void compareToDayAnswerAndUserAnswer() {
        Letters todayAnswer = Letters.of("abcde");
        Answer answer = new Answer(todayAnswer);
        Letters userAnswer = Letters.of("abcde");

        assertThat(answer.compare(userAnswer).getList()).containsOnly(LetterResult.GREEN);
    }

    @DisplayName(" 정답과 답안이 모두 맞는 경우에는 모두 GREEN 이다")
    @Test
    void compare_5green() {
        Letters todayAnswer = Letters.of("abcde");
        Answer answer = new Answer(todayAnswer);
        Letters userAnswer = Letters.of("abcde");

        assertThat(answer.compare(userAnswer).getList()).containsOnly(LetterResult.GREEN);
    }

    @DisplayName(" 정답과 답안를 비교하여 단어와 위치가 일치하면 GREEN 이다")
    @ParameterizedTest
    @CsvSource({"hello, 5", "aallo, 3", "hasde, 1"})
    void compare_green(String input, int expected) {
        Letters todayAnswer = Letters.of("hello");
        Answer answer = new Answer(todayAnswer);
        Letters userAnswer = Letters.of(input);

        assertThat(
                answer.compare(userAnswer)
                        .getList()
                        .stream().filter(letterResult -> letterResult == LetterResult.GREEN).collect(Collectors.toList())
        ).hasSize(expected);
    }


    @DisplayName(" 정답과 답안를 비교하여 단어는 같고 위치가 다르면 YELLOW 이다.")
    @ParameterizedTest
    @CsvSource({"ahbcd, 1", "aheob, 3"})
    void compare_yellow(String input, int expected) {
        Letters todayAnswer = Letters.of("hello");
        Answer answer = new Answer(todayAnswer);
        Letters userAnswer = Letters.of(input);

        assertThat(
                answer.compare(userAnswer)
                        .getList()
                        .stream().filter(letterResult -> letterResult == LetterResult.YELLOW).collect(Collectors.toList())
        ).hasSize(expected);
    }

    @DisplayName(" 정답과 답안를 비교하여 정답 글자도 안맞고, 위치도 다른 경우 GRAY 이다")
    @ParameterizedTest
    @CsvSource({"asbcd, 5", "aheob, 2"})
    void compare_gray(String input, int expected) {
        Letters todayAnswer = Letters.of("hello");
        Answer answer = new Answer(todayAnswer);
        Letters userAnswer = Letters.of(input);

        assertThat(
                answer.compare(userAnswer)
                        .getList()
                        .stream().filter(letterResult -> letterResult == LetterResult.GRAY).collect(Collectors.toList())
        ).hasSize(expected);
    }

    @DisplayName(" 두 개의 동일한 문자를 입력하고 그중 하나가 회색으로 표시되면 해당 문자 중 하나만 최종 단어에 나타난다")
    @ParameterizedTest
    @MethodSource("provideCompareFinalLetter")
    void compare_final_letter(String input, List<LetterResult> expect) {
        Letters todayAnswer = Letters.of("hello");
        Answer answer = new Answer(todayAnswer);
        Letters userAnswer = Letters.of(input);

        assertThat(answer.compare(userAnswer).getList()).isEqualTo(expect);
    }

    private static Stream<Arguments> provideCompareFinalLetter() { // argument source method
        return Stream.of(
                Arguments.of(
                        "helll",
                        List.of(LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GRAY)),
                Arguments.of(
                        "heool",
                        List.of(LetterResult.GREEN, LetterResult.GREEN, LetterResult.YELLOW, LetterResult.GRAY, LetterResult.YELLOW)),
                Arguments.of(
                        "heooo",
                        List.of(LetterResult.GREEN, LetterResult.GREEN, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GREEN)));
    }
}
