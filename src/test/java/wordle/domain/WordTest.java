package wordle.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WordTest {

    @ParameterizedTest
    @ValueSource(chars = {'A', 'a', 'Z', 'z'})
    void Word생성성공(final char input) {
        final char lowerInput = Character.toLowerCase(input);
        final Word word = new Word(input, input);

        assertThat(word.getValue()).isEqualTo(lowerInput);
    }

    @ParameterizedTest
    @ValueSource(chars = {'1', '0', '-', '?', '@', 'ㄱ', '아', '부'})
    void Word생성실패_String이아님(final char input) {
        assertThatThrownBy(() -> new Word(input, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}