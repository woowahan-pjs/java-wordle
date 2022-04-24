package test.wordle.domain;

import org.junit.jupiter.api.Test;
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

    @Test
    void contain_가지고있음() {
        final Word word = new Word('a', 1);
        final Words words = new Words("happy");

        assertThat(words.contains(word)).isTrue();
    }


    @Test
    void contain_가지고있지않음() {
        final Word word = new Word('z', 1);
        final Words words = new Words("happy");

        assertThat(words.contains(word)).isFalse();
    }

}
