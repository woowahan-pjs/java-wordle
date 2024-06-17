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
}
