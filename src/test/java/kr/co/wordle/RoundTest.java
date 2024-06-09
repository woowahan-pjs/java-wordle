package kr.co.wordle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "asdf", "a", "133ke", "아ddsz", ""})
    void 입력값_유효하지_않음(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Round(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"cigar", "rebut", "sissy", "humph"})
    void 입력값_유효(String input) {
        Assertions.assertDoesNotThrow(() -> new Round(input));
    }
}
