package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static wordle.domain.ResultType.*;

public class AnswerTest {

    @Test
    void 정답은_정답과_동일한_답안이_들어오면_모두_MATCHED인_결과를_반환한다() {
        // given
        final Answer answer = new Answer("cigar");
        final Guess guess = new Guess("cigar");

        final Result expectedResult = new Result(List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED));

        // when
        final Result result = answer.examine(guess);

        // then
        assertEquals(result, expectedResult);
    }

    @Test
    void 정답은_5글자가_아니면_예외를_발생한다() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Answer("abcdef"));
    }


    @Test
    void 인덱스가_들어오면_해당_인덱스의_알파벳을_반환한다() {
        final Answer answer = new Answer("tasty");

        final Alphabet alphabet = answer.find(0);

        assertEquals(alphabet, Alphabet.t);
    }

    @Test
    void 알파벳_조회시_답안_길이보다_긴_인덱스가_들어오면_예외를_발생한다() {
        final Answer answer = new Answer("tasty");

        assertThrows(IllegalArgumentException.class, () -> answer.find(5));
    }

    @Test
    void 매칭_타입_단어와_동일한_단어가_앞에_존재할_경우_미존재_타입으로_처리한다() {
        final Answer answer = new Answer("apple");
        final Guess guess = new Guess("hello");
        final Result expected = new Result(List.of(MISMATCHED, EXIST, MISMATCHED, MATCHED, MISMATCHED));

        final Result actual = answer.examine(guess);
        assertEquals(expected, actual);
    }
}
