package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class WordTest {

    @Test
    void 주어진_단어가_5글자가_아니라면_예외를_발생한다() {
        // given when then
        assertThrowsExactly(RuntimeException.class, () -> new Word("abcdef"));
    }
}
