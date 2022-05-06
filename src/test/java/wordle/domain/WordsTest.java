package wordle.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class WordsTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcde", "defgh", "zxcvb"})
    void Words생성성공(final String input) {
        final Words words = new Words(input);
        final boolean result = Arrays.stream(input.split("")).allMatch(v -> words.contains(new Word(v.charAt(0), 0)));

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abce", "defghs", "def5s"})
    void Words생성실패(final String input) {
        assertThatThrownBy(() -> new Words(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Words생성실패_Null() {
        assertThatThrownBy(() -> new Words(null))
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

    @Test
    void position체크() {
        final Words words = new Words("happy");
        assertThat(words.getWordList().get(0).getPosition()).isEqualTo(0);
    }

}
