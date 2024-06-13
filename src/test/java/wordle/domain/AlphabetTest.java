package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AlphabetTest {

    @Test
    void 소문자_영단어로_Alphabet을_생성할_수_있다() {
        assertDoesNotThrow(() -> Alphabet.of('a'));
    }
}
