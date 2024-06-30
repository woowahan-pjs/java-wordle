package wordle;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import wordle.model.*;

class LetterComparatorTest {

    @ParameterizedTest
    @MethodSource("provideResultData")
    void compareLetters(Letters inputLetters, String resultData) {
        // given
        LetterComparator letterComparator = new LetterComparator(new ResultStorage());
        Letters answerLetters = new Letters(
                List.of(
                        new Letter(0, 'a'),
                        new Letter(1, 'p'),
                        new Letter(2, 'p'),
                        new Letter(3, 'l'),
                        new Letter(4, 'e')
                ));

        // when
        Result result = letterComparator.compare(answerLetters, inputLetters);

        // then
        assertThat(result.toString()).isEqualTo(resultData);
    }

    public static Stream<Arguments> provideResultData() {
        return Stream.of(
                Arguments.of(new Letters(
                        List.of(new Letter(0, 'h'),
                                new Letter(1, 'e'),
                                new Letter(2, 'l'),
                                new Letter(3, 'l'),
                                new Letter(4, 'o'))), "⬜\uD83D\uDFE8⬜\uD83D\uDFE9⬜"),
                Arguments.of(new Letters(
                        List.of(new Letter(0, 'm'),
                                new Letter(1, 'e'),
                                new Letter(2, 'l'),
                                new Letter(3, 'o'),
                                new Letter(4, 'n'))), "⬜\uD83D\uDFE8\uD83D\uDFE8⬜⬜"),
                Arguments.of(new Letters(
                        List.of(new Letter(0, 'a'),
                                new Letter(1, 'p'),
                                new Letter(2, 'p'),
                                new Letter(3, 'l'),
                                new Letter(4, 'e'))), "\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9")
        );
    }
}
