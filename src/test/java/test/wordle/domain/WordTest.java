package test.wordle.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WordTest {

    @ParameterizedTest
    @ValueSource(chars = {'A', 'a', 'Z', 'z'})
    void Word생성성공(final char input) {
        final char lowerInput = Character.toLowerCase(input);
        final Word word = new Word(input);

        assertThat(word.getValue()).isEqualTo(lowerInput);
    }
}