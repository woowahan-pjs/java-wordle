package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GuessTest {

    @Test
    void 단어에_알파벳_소문자가_아닌_문자가_들어오면_예외를_반환한다() {
        // given
        String word = "Cigar";

        // when & then
        assertThrows(RuntimeException.class, () -> new Guess(word));
    }
}
