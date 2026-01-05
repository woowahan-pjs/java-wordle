package wordle.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    @EnumSource(value = ResultType.class, names = {"MATCHED"})
    @ParameterizedTest(name = "모든 ResultType이 {0}일 때 성공되었다고 판단한다")
    void 모든_ResultType이_Matched라면_매칭_성공_여부를_true로_반환한다(final ResultType resultType) {
        final Result result = new Result(List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, resultType));

        assertTrue(result.allMatched());
    }

    @EnumSource(value = ResultType.class, names = {"NONE", "MISMATCHED", "EXIST"})
    @ParameterizedTest(name = "ResultType 중 하나라도 {0}일 때 성공되지 않았다고 판단한다")
    void 모든_ResultType이_Matched가_아니라면_매칭_성공_여부를_false로_반환한다(final ResultType resultType) {
        final Result result = new Result(List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, resultType));

        assertFalse(result.allMatched());
    }

    @CsvSource(value = {"0, MATCHED", "1, MISMATCHED", "2, EXIST"})
    @ParameterizedTest(name = "Result 가 생성될 때 {0} 순번의 ResultType {1} 를 반환할 수 있다")
    void Result_가_생성될_때_N번의_ResultType_를_반환할_수_있다(final int index, final ResultType expected) {
        final List<ResultType> matched = List.of(ResultType.MATCHED, ResultType.MISMATCHED, ResultType.EXIST, ResultType.MATCHED, ResultType.MATCHED);
        final Result result = new Result(matched);

        assertEquals(expected, result.get(index));
    }

    @EnumSource(value = ResultType.class, names = {"MATCHED", "NONE", "MISMATCHED", "EXIST"})
    @ParameterizedTest(name = "Result 가 생성될 때 {0} 가 포함된 ResultType 리스트를 반환할 수 있다")
    void Result_가_생성될_때의_ResultType_리스트를_반환할_수_있다(final ResultType resultType) {
        final List<ResultType> expected = List.of(ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, ResultType.MATCHED, resultType);
        final Result result = new Result(expected);
        final List<ResultType> actual = result.getResult();

        assertEquals(expected, actual);
    }
}
