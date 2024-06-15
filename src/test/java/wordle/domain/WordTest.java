package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordTest {

    @Test
    void 게임_단어에_5글자가_아닌_문자열이_들어오면_예외를_발생한다() {
        // given when then
        assertThrowsExactly(RuntimeException.class, () -> new Word("abcdef"));
    }

    @Test
    void 게임_단어에_5글자_알파벳_소문자_문자가_들어오면_생성할_수_있다() {
        // given
        String word = "cigar";

        assertDoesNotThrow(() -> new Word(word));
    }

    @Test
    void 게임_단어에_알파벳_소문자가_아닌_문자가_들어오면_예외를_반환한다() {
        // given
        String word = "Cigar";

        // when & then
        assertThrows(RuntimeException.class, () -> new Word(word));
    }
}
