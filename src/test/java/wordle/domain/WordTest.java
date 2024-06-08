package wordle.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import wordle.exception.WordInputNotValidException;

public class WordTest {

    @Test
    void Word를_생성한다() {
        assertDoesNotThrow(() -> new Word("apple"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "testss"})
    void Word를_생성할_때_다섯글자가_아니면_실패한다(String input) {
        assertThatThrownBy(() -> new Word(input))
                .isInstanceOf(WordInputNotValidException.class);
    }

}
