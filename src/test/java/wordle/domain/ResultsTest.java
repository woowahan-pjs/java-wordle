package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultsTest {

    @Test
    void 문자가_모두_일치하는_결과가_있는_경우_true를_반환한다() {
        // given
        List<Result> resultList = List.of(
                new Result(List.of(ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED))
        );
        Results results = new Results(resultList);

        // when
        results.hasAnswer();

        // then
        assertTrue(results.hasAnswer());
    }

    @Test
    void 문자가_모두_일치하는_결과가_없는_경우_false를_반환한다() {
        // given
        List<Result> resultList = List.of(
                new Result(List.of(ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MATCHED, ResultType.MISMATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED))
        );
        Results results = new Results(resultList);

        // when
        results.hasAnswer();

        // then
        assertFalse(results.hasAnswer());
    }
}
