package wordle.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WordTest {

    @Test
    void 다섯_글자_단어는_정상적으로_생성된다() {
        assertThatCode(() -> new Word("apple"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"good", "hungry", ""})
    void 다섯_글자가_아닌_단어로_생성하면_예외가_발생한다(final String input) {
        assertThatThrownBy(() -> new Word(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}