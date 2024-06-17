package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnswerTest {

    @Test
    void 정답은_정답과_동일한_답안이_들어오면_모두_MATCHED인_결과를_반환한다() {
        // given
        Answer answer = new Answer("cigar");
        Guess guess = new Guess("cigar");

        Result expectedResult = new Result(List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED));

        // when
        Result result = answer.examineResult(guess);

        // then
        assertEquals(result, expectedResult);
    }

    @Test
    void 정답은_5글자가_아니면_예외를_발생한다() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Answer("abcdef"));
    }


    @Test
    void 알파벳과_인덱스가_들어오면_해당_인덱스_이전의_알파벳_개수를_반환한다() {
        final Answer answer = new Answer("tasty");
        final long count = answer.countAlphabets(Alphabet.t, 4);

        assertEquals(2, count);
    }


    @Test
    void 답안_길이보다_긴_인덱스가_들어오면_예외를_발생한다() {
        final Answer answer = new Answer("tasty");

        assertThrowsExactly(IllegalArgumentException.class, () -> answer.countAlphabets(Alphabet.t, 6));
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
}
