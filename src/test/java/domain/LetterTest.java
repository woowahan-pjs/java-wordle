package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LetterTest {
    @ParameterizedTest
    @ValueSource(chars = {'a', 'z', 'A', 'Z'})
    void construct() {
        Letter letter = new Letter('a');
        assertThat(letter).isEqualTo(new Letter('a'));
    }

    @ParameterizedTest
    @DisplayName("영문자 외 다른 문자가 들어오면 에러를 발생시킨다")
    @ValueSource(chars = {'@', 'ㅏ', 'ㅇ', '`'})
    void occurExceptionWhenNotAlphabet(char letter) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Letter(letter)
        );
    }
}
