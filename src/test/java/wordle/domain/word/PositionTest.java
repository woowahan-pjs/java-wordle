package wordle.domain.word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @ParameterizedTest
    @CsvSource({"0", "5"})
    void create(int value) {
        assertThatCode(() -> Position.from(value))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"-1", "6"})
    void createFail(int value) {
        assertThatThrownBy(() -> Position.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
