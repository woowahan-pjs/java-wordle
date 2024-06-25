package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class GameWordTest {

    @ValueSource(strings = {"", "a", "ab", "abc", "abcd", "abcdef"})
    @ParameterizedTest(name = "게임 단어는 생성할 때 5글자가 아닌 알파벳 문자열 {0} 이 들어오면 예외를 발생한다")
    void 게임_단어는_생성할_때_5글자가_아닌_문자열이_들어오면_예외를_발생한다(final String word) {
        assertThrowsExactly(IllegalArgumentException.class, () -> new GameWord(word));
    }

    @ValueSource(strings = {"ㄱabcde", "!@$fz", "24315", "a1b2c", "a1b2c$"})
    @ParameterizedTest(name = "게임 단어는 생성할 때 5글자이지만 알파벳이 아닌 문자도 섞인 문자열 {0} 이 들어오면 예외를 발생한다")
    void 게임_단어는_생성할_때_5글자이지만_알파벳이_아닌_문자도_섞인_문자열이_들어오면_예외를_발생한다(final String word) {
        assertThrowsExactly(IllegalArgumentException.class, () -> new GameWord(word));
    }

    @ValueSource(strings = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE"})
    @ParameterizedTest(name = "게임 단어는 5글자 알파벳 문자열 {0}이 들어오면 생성할 수 있다")
    void 게임_단어는_5글자_알파벳_문자가_들어오면_생성할_수_있다(final String word) {
        assertDoesNotThrow(() -> new GameWord(word));
    }

    @DisplayName("게임 단어는 단어의 길이를 반환할 수 있다")
    @Test
    void 게임_단어는_단어의_길이를_반환할_수_있다() {
        final String word = "abcde";
        final GameWord gameWord = new GameWord(word);

        assertEquals(word.length(), gameWord.size());
    }

    @CsvSource(value = {"0, a", "1, b", "2, c", "3, d", "4, e"})
    @ParameterizedTest(name = "게임 단어는 {0} 순번의 알파벳 {1} 을 반환할 수 있다")
    void 게임_단어는_N번의_알파벳을_반환할_수_있다(final int index, final char alphabet) {
        final Alphabet expected = Alphabet.of(alphabet);
        final String word = "abcde";
        final GameWord gameWord = new GameWord(word);

        assertEquals(expected, gameWord.find(index));
    }

    @ValueSource(strings = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE"})
    @ParameterizedTest(name = "게임 단어는 {0} 와 같은 단어인지 확인할 수 있다")
    void 게임_단어는_주어진_문자열과_같은_단어인지_확인할_수_있다(final String word) {
        final GameWord gameWord = new GameWord(word);

        assertTrue(gameWord.isSameAs(word));
    }

    @ValueSource(strings = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE"})
    @ParameterizedTest(name = "게임 단어는 가지고 있는 단어를 문자열 {0}로 반환할 수 있다")
    void 게임_단어는_가지고_있는_단어를_문자열로_반환할_수_있다(final String expected) {
        final GameWord gameWord = new GameWord(expected);

        assertEquals(expected, gameWord.word());
    }
}
