package test.wordle.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WordsTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcde", "defgh", "zxcvb"})
    void Words생성성공(final String input) {
        final Words words = new Words(input);

        assertThat(words.length()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abce", "defghs", "def5s"})
    void Words생성실패(final String input) {
        assertThatThrownBy(() -> new Words(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
