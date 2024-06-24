package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameWordTest {

    @Test
    void 게임_단어에_5글자가_아닌_문자열이_들어오면_예외를_발생한다() {
        // given when then
        assertThrowsExactly(IllegalArgumentException.class, () -> new GameWord("abcdef"));
    }

    @Test
    void 게임_단어에_5글자_알파벳_소문자_문자가_들어오면_생성할_수_있다() {
        // given
        final String word = "cigar";

        assertDoesNotThrow(() -> new GameWord(word));
    }

    @Test
    void 게임_단어에_알파벳_소문자가_아닌_문자가_들어오더도_성생할_수_있다() {
        // given
        final String word = "Cigar";

        // when & then
        assertDoesNotThrow(() -> new GameWord(word));
    }
}
