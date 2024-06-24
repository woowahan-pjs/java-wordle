package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import wordle.exception.InvalidAlphabetException;

public class AlphabetTest {

    @Test
    void 알파벳은_대소문자를_구분하지_않는다() {
        final Alphabet alphabetA = new Alphabet('a');

        assertThat(alphabetA).isEqualTo(new Alphabet('A'));
    }

    @Test
    void 알파벳이_같으면_동등한_객체이다() {
        final Alphabet alphabetA = new Alphabet('a');

        assertThat(alphabetA).isEqualTo(new Alphabet('a'));
    }

    @ParameterizedTest
    @ValueSource(chars = {'1', 'ㄱ', ' ', '!', '.'})
    void 알파벳이_아니면_예외가_발생한다(final char input) {
        assertThatThrownBy(() -> new Alphabet(input))
                .isInstanceOf(InvalidAlphabetException.class);
    }
}
