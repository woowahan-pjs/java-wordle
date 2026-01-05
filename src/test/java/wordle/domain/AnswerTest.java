package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static wordle.domain.ResultType.*;

public class AnswerTest {

    @ValueSource(strings = {"", "a", "ab", "abc", "abcd", "abcdef"})
    @ParameterizedTest(name = "정답은 생성할 때 5글자가 아닌 알파벳 문자열 {0} 이 들어오면 예외를 발생한다")
    void 정답은_생성할_때_5글자가_아닌_문자열이_들어오면_예외를_발생한다(final String word) {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Answer(word));
    }

    @ValueSource(strings = {"ㄱabcde", "!@$fz", "24315", "a1b2c", "a1b2c$"})
    @ParameterizedTest(name = "정답은 생성할 때 5글자이지만 알파벳이 아닌 문자도 섞인 문자열 {0} 이 들어오면 예외를 발생한다")
    void 정답은_생성할_때_5글자이지만_알파벳이_아닌_문자도_섞인_문자열이_들어오면_예외를_발생한다(final String word) {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Answer(word));
    }

    @ValueSource(strings = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE"})
    @ParameterizedTest(name = "정답은 5글자 알파벳 문자열 {0}이 들어오면 생성할 수 있다")
    void 정답은_5글자_알파벳_문자가_들어오면_생성할_수_있다(final String word) {
        assertDoesNotThrow(() -> new Answer(word));
    }

    @CsvSource(value = {"0, t", "1, a", "2, s", "3, t", "4, y"})
    @ParameterizedTest(name = "정답 {0}은 순번의 알파벳 {1} 을 반환할 수 있다")
    void 정답은_인덱스가_들어오면_해당_인덱스의_알파벳을_반환한다(final int index, final char alphabet) {
        final Alphabet expected = Alphabet.of(alphabet);
        final Answer answer = new Answer("tasty");

        assertEquals(expected, answer.find(index));
    }

    @ValueSource(strings = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE"})
    @ParameterizedTest(name = "정답 {0}은 가지고 있는 단어보다 긴 인덱스가 들어오면 예외를 발생한다")
    void 정답은_알파벳_조회시_답안_길이보다_긴_인덱스가_들어오면_예외를_발생한다(final String word) {
        final Answer answer = new Answer(word);

        assertThrows(IllegalArgumentException.class, () -> answer.find(word.length()));
    }

    @ValueSource(strings = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE"})
    @ParameterizedTest(name = "정답 {0}은 가지고 있는 단어와 동일한 답안{0}이 들어오면 모두 MATCHED인 결과를 반환한다")
    void 정답은_정답과_동일한_답안이_들어오면_모두_MATCHED인_결과를_반환한다(final String word) {
        final Answer answer = new Answer(word);
        final Guess guess = new Guess(word);

        final Result expected = new Result(List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED));

        assertEquals(expected, answer.examine(guess));
    }

    @CsvSource(value = {"abcde, fghij", "abcde, ABCDE", "klmno, pqrst", "uewfk, zxcvb"})
    @ParameterizedTest(name = "정답 {0}은 가지고 있는 단어와 문자가 하나도 같지 않은 답안 {1}이 들어오면 모두 MISMATCHED인 결과를 반환한다")
    void 정답은_문자가_하나도_같지_않은_답안이_들어오면_모두_MISMATCHED인_결과를_반환한다(final String answerWord, final String guessWord) {
        final Answer answer = new Answer(answerWord);
        final Guess guess = new Guess(guessWord);
        final Result expected = new Result(List.of(MISMATCHED, MISMATCHED, MISMATCHED, MISMATCHED, MISMATCHED));

        assertEquals(expected, answer.examine(guess));
    }

    @CsvSource(value = {"abcde, bcdea", "abcde, cdeab", "plmno, lmnop", "uewfk, ewfku"})
    @ParameterizedTest(name = "정답 {0}은 가지고 있는 단어와 문자가 일부만 일치하는 답안 {1}이 들어오면 일치하는 문자만 EXIST 로 처리한다")
    void 정답은_가지고_있는_단어와_문자가_일부만_일치하는_답안이_들어오면_일치하는_문자만_EXIST로_처리한다(final String answerWord, final String guessWord) {
        final Answer answer = new Answer(answerWord);
        final Guess guess = new Guess(guessWord);
        final Result expected = new Result(List.of(EXIST, EXIST, EXIST, EXIST, EXIST));

        assertEquals(expected, answer.examine(guess));
    }

    @DisplayName("정답은 가지고 있는 단어와 문자가 일치, 존재, 미존재 하는 답안이 들어오면 매칭 결과를 반환한다")
    @Test
    void 정답은_가지고_있는_단어와_문자가_일치_존재_미존재_하는_답안이_들어오면_매칭_결과를_반환한다() {
        final Answer answer = new Answer("hello");
        final Guess guess = new Guess("apple");
        final Result expected = new Result(List.of(MISMATCHED, MISMATCHED, MISMATCHED, MATCHED, EXIST));

        final Result actual = answer.examine(guess);
        assertEquals(expected, actual);
    }

    @DisplayName("정답은 가지고 있는 단어와 문자가 일부만 일치하는 답안이 들어오면 일치하는 문자만 MATCHED로 처리한다")
    @Test
    void 정답은_가지고_있는_단어와_문자가_일부만_일치하는_답안이_앞에_들어오면_일치하는_문자만_MATCHED로_처리한다() {
        final Answer answer = new Answer("apple");
        final Guess guess = new Guess("hello");
        final Result expected = new Result(List.of(MISMATCHED, EXIST, MISMATCHED, MATCHED, MISMATCHED));

        final Result actual = answer.examine(guess);
        assertEquals(expected, actual);
    }

    @DisplayName("정답은 가지고 있는 단어와 문자가 일부만 일치하는 답안이 뒤에 들어오면 일치하는 문자만 MATCHED로 처리한다")
    @Test
    void 정답은_가지고_있는_단어와_문자가_일부만_일치하는_답안이_뒤에_들어오면_일치하는_문자만_MATCHED로_처리한다() {
        final Answer answer = new Answer("hello");
        final Guess guess = new Guess("olleh");
        final Result expected = new Result(List.of(EXIST, EXIST, MATCHED, EXIST, EXIST));

        final Result actual = answer.examine(guess);
        assertEquals(expected, actual);
    }
}
