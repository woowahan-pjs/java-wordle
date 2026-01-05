package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuessTest {

    @Test
    void 답안은_5글자가_아니면_예외를_발생한다() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Guess("abcdef"));
    }

    @Test
    void 알파벳과_인덱스가_들어오면_해당_인덱스_이전의_알파벳_개수를_반환한다() {
        final Guess guess = new Guess("tasty");
        final long count = guess.countAlphabets(Alphabet.t, 4);

        assertEquals(2, count);
    }

    @Test
    void 답안_길이보다_긴_인덱스가_들어오면_예외를_발생한다() {
        final Guess guess = new Guess("tasty");

        assertThrowsExactly(IllegalArgumentException.class, () -> guess.countAlphabets(Alphabet.t, 6));
    }

    @Test
    void 인덱스가_들어오면_해당_인덱스의_알파벳을_반환한다() {
        final Guess guess = new Guess("tasty");

        final Alphabet alphabet = guess.find(0);

        assertEquals(alphabet, Alphabet.t);
    }

    @Test
    void 알파벳_조회시_답안_길이보다_긴_인덱스가_들어오면_예외를_발생한다() {
        final Guess guess = new Guess("tasty");

        assertThrows(IllegalArgumentException.class, () -> guess.find(5));
    }
}
