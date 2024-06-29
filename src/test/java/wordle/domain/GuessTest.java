package wordle.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class GuessTest {

    @ValueSource(strings = {"", "a", "ab", "abc", "abcd", "abcdef"})
    @ParameterizedTest(name = "답안은 생성할 때 5글자가 아닌 알파벳 문자열 {0} 이 들어오면 예외를 발생한다")
    void 답안은_생성할_때_5글자가_아닌_문자열이_들어오면_예외를_발생한다(final String word) {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Guess(word));
    }

    @ValueSource(strings = {"ㄱabcde", "!@$fz", "24315", "a1b2c", "a1b2c$"})
    @ParameterizedTest(name = "답안은 생성할 때 5글자이지만 알파벳이 아닌 문자도 섞인 문자열 {0} 이 들어오면 예외를 발생한다")
    void 답안은_생성할_때_5글자이지만_알파벳이_아닌_문자도_섞인_문자열이_들어오면_예외를_발생한다(final String word) {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Guess(word));
    }

    @ValueSource(strings = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE"})
    @ParameterizedTest(name = "답안은 5글자 알파벳 문자열 {0}이 들어오면 생성할 수 있다")
    void 답안은_5글자_알파벳_문자가_들어오면_생성할_수_있다(final String word) {
        assertDoesNotThrow(() -> new Guess(word));
    }

    @CsvSource(value = {"0, t", "1, a", "2, s", "3, t", "4, y"})
    @ParameterizedTest(name = "답안은 {0} 순번의 알파벳 {1} 을 반환할 수 있다")
    void 답안은_인덱스가_들어오면_해당_인덱스의_알파벳을_반환한다(final int index, final char alphabet) {
        final Alphabet expected = Alphabet.of(alphabet);
        final Guess guess = new Guess("tasty");

        assertEquals(expected, guess.find(index));
    }

    @ValueSource(strings = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE"})
    @ParameterizedTest(name = "답안은 가지고 있는 단어보다 긴 인덱스가 들어오면 예외를 발생한다")
    void 답안은_알파벳_조회시_답안_길이보다_긴_인덱스가_들어오면_예외를_발생한다(final String word) {
        final Guess guess = new Guess(word);

        assertThrows(IllegalArgumentException.class, () -> guess.find(word.length()));
    }
}
