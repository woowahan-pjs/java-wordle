package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResultsTest {

    @Test
    void 결과들을_가지고_있다면_개수를_반환할_수_있다() {
        // given
        final List<Result> resultList = List.of(
                new Result(List.of(ResultType.EXIST, ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.EXIST, ResultType.MATCHED, ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.EXIST, ResultType.MATCHED, ResultType.EXIST, ResultType.MISMATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MISMATCHED, ResultType.MATCHED, ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED))
        );
        final Results results = new Results(resultList);

        // when
        final int actual = results.size();

        // then
        assertEquals(actual, 4);
    }


    @Test
    void 문자가_모두_일치하는_결과가_있는_경우_true를_반환한다() {
        // given
        final List<Result> resultList = List.of(
                new Result(List.of(ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED))
        );
        final Results results = new Results(resultList);

        // when
        results.hasAnswer();

        // then
        assertTrue(results.hasAnswer());
    }

    @Test
    void 문자가_모두_일치하는_결과가_없는_경우_false를_반환한다() {
        // given
        final List<Result> resultList = List.of(
                new Result(List.of(ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MATCHED, ResultType.MISMATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED))
        );
        final Results results = new Results(resultList);

        // when
        results.hasAnswer();

        // then
        assertFalse(results.hasAnswer());
    }
}
