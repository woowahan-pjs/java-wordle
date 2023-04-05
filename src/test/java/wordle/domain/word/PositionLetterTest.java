package wordle.domain.word;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PositionLetterTest {

    @Test
    void of() {
        assertThatCode(() -> PositionLetter.of(0, 'a'))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({
            "0, a, true",
            "1, a, false",
            "1, b, false",
    })
    void hasSameValueAndDiffPosition(int position, char letter, boolean expected) {
        PositionLetter positionLetter = PositionLetter.of(position, letter);
        PositionLetter target = PositionLetter.of(1, 'a');

        boolean actual = positionLetter.hasSameValueAndDiffPosition(target);

        assertThat(actual).isEqualTo(expected);
    }
}
