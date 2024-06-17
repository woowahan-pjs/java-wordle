package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class GuessTest {

    @Test
    void 답안은_5글자가_아니면_예외를_발생한다() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Guess("abcdef"));
    }
}
