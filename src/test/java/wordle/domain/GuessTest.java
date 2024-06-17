package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GuessTest {

    @Test
    void 답안은_5글자가_아니면_예외를_발생한다() {
        assertThrows(RuntimeException.class, () -> new Guess("abcdef"));
    }
}

