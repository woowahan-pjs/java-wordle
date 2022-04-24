package test.wordle.domain;

import org.junit.jupiter.api.Test;
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
    @ValueSource(chars = {'1', '0', '-', '?', '@'})
    void Word생성실패_String이아님(final char input) {
        assertThatThrownBy(() -> new Word(input, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matches결과_GREEN() {
        final char input = 'a';
        final Word source = new Word(input, 1);
        final Word target = new Word(input, 1);

        assertThat(source.matches(target)).isEqualTo(MatchStatus.GREEN);
    }


    @Test
    void matches결과_YELLOW() {
        final char input = 'a';
        final Word source = new Word(input, 1);
        final Word target = new Word(input, 2);

        assertThat(source.matches(target)).isEqualTo(MatchStatus.YELLOW);
    }


    @Test
    void matches결과_GREY() {
        final Word source = new Word('a', 1);
        final Word target = new Word('b', 2);

        assertThat(source.matches(target)).isEqualTo(MatchStatus.GREY);
    }

}