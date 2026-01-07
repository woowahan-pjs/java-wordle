package wordle.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnswerTest {

    @ParameterizedTest
    @MethodSource("provideResultData")
    void compareLetters(Letters inputLetters, List<String> resultData) {
        // given
        Letters answerLetters = new Letters(
                List.of(
                        new Letter(0, 'a'),
                        new Letter(1, 'p'),
                        new Letter(2, 'p'),
                        new Letter(3, 'l'),
                        new Letter(4, 'e')
                ));
        Answer answer = new Answer(answerLetters);

        // when
        Result result = answer.evaluate(inputLetters);

        // then
        assertThat(result.getTiles()).isEqualTo(resultData);
    }

    public static Stream<Arguments> provideResultData() {
        return Stream.of(
                Arguments.of(new Letters(
                                List.of(new Letter(0, 'h'),
                                        new Letter(1, 'e'),
                                        new Letter(2, 'l'),
                                        new Letter(3, 'l'),
                                        new Letter(4, 'o'))),
                        List.of("⬜", "🟨", "⬜", "🟩", "⬜")),
                Arguments.of(new Letters(
                                List.of(new Letter(0, 'm'),
                                        new Letter(1, 'e'),
                                        new Letter(2, 'l'),
                                        new Letter(3, 'o'),
                                        new Letter(4, 'n'))),
                        List.of("⬜", "🟨", "🟨", "⬜", "⬜")),
                Arguments.of(new Letters(
                                List.of(new Letter(0, 'a'),
                                        new Letter(1, 'p'),
                                        new Letter(2, 'p'),
                                        new Letter(3, 'l'),
                                        new Letter(4, 'e'))),
                        List.of("🟩", "🟩", "🟩", "🟩", "🟩"))
        );
    }
}
