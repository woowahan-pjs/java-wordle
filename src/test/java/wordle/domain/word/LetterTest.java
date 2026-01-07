package wordle.domain.word;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LetterTest {

    @ParameterizedTest
    @CsvSource({"a", "z"})
    void create(char ch) {
        assertThatCode(() -> Letter.from(ch))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"0", "$"})
    void createFail(char ch) {
        assertThatThrownBy(() -> Letter.from(ch))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
