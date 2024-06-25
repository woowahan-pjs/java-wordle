package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResultsTest {

    @DisplayName("결과 목록은 가지고 있는 결과의 개수를 반환할 수 있다")
    @Test
    void 결과_목록은_가지고_있는_결과의_개수를_반환할_수_있다() {
        final List<Result> resultList = List.of(
                new Result(List.of(ResultType.EXIST, ResultType.EXIST, ResultType.EXIST, ResultType.EXIST, ResultType.EXIST)),
                new Result(List.of(ResultType.MISMATCHED, ResultType.MISMATCHED, ResultType.MISMATCHED, ResultType.MISMATCHED, ResultType.MISMATCHED)),
                new Result(List.of(ResultType.EXIST, ResultType.MISMATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MISMATCHED, ResultType.MATCHED, ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED))
        );
        final Results results = new Results(resultList);

        assertEquals(resultList.size(), results.size());
    }


    @DisplayName("결과 목록은 모든 결과가 매칭된 결과가 있는 경우 true를 반환한다")
    @Test
    void 결과_목록은_모든_결과가_매칭된_결과가_있는_경우_true를_반환한다() {
        final List<Result> resultList = List.of(
                new Result(List.of(ResultType.EXIST, ResultType.EXIST, ResultType.EXIST, ResultType.EXIST, ResultType.EXIST)),
                new Result(List.of(ResultType.MISMATCHED, ResultType.MISMATCHED, ResultType.MISMATCHED, ResultType.MISMATCHED, ResultType.MISMATCHED)),
                new Result(List.of(ResultType.EXIST, ResultType.MISMATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MISMATCHED, ResultType.MATCHED, ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED))
        );
        final Results results = new Results(resultList);

        assertTrue(results.hasAnswer());
    }

    @DisplayName("결과 목록은 모든 결과가 매칭된 결과가 없는 경우 false를 반환한다")
    @Test
    void 결과_목록은_모든_결과가_매칭된_결과가_없는_경우_false를_반환한다() {
        final List<Result> resultList = List.of(
                new Result(List.of(ResultType.EXIST, ResultType.EXIST, ResultType.EXIST, ResultType.EXIST, ResultType.EXIST)),
                new Result(List.of(ResultType.MISMATCHED, ResultType.MISMATCHED, ResultType.MISMATCHED, ResultType.MISMATCHED, ResultType.MISMATCHED)),
                new Result(List.of(ResultType.EXIST, ResultType.MISMATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED)),
                new Result(List.of(ResultType.MISMATCHED, ResultType.MATCHED, ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED))
        );
        final Results results = new Results(resultList);

        assertFalse(results.hasAnswer());
    }
}
