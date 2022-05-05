package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LettersTest {

    @Test
    @DisplayName("영단어는 Letters로 이루어져 있다.")
    void constructor() {
        Letters letters = Letters.of("hello");
        assertThat(letters).isEqualTo(Letters.of("hello"));
    }

    @DisplayName("Letters는 5글자가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcd, abcdef"})
    void inValidLength(String source) {
        assertThatIllegalArgumentException().isThrownBy(() -> Letters.of(source));
    }

    @DisplayName("Letters가 영단어가 아닌 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"알곘습니다", "1a2b3", "@#&*("})
    void checkEnglishWords(String source) {
        assertThatIllegalArgumentException().isThrownBy(() -> Letters.of(source));
    }
}