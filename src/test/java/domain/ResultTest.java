package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("결과 테스트")
class ResultTest {

    @DisplayName("결과 생성 테스트")
    @Test
    void createResultsTest() {
        List<MatchStatus> statuses = List.of(
                MatchStatus.GREEN,
                MatchStatus.GREEN,
                MatchStatus.GREEN,
                MatchStatus.GREEN,
                MatchStatus.GREEN
        );
        assertThatCode(() -> new Result(statuses))
                .doesNotThrowAnyException();
    }

    @DisplayName("MatchStatus 가 5개가 아니면 IllegalArgumentException 반환")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 6})
    void createResultsWithInvalidSizeTest(int size) {
        List<MatchStatus> statuses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            statuses.add(MatchStatus.GREEN);
        }
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Result(statuses));
    }
}
