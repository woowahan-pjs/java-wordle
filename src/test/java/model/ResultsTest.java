package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

    @DisplayName("입력한 문자가 정답문자열과 일치하면 결과는 true를 반환한다.")
    @Test
    void isMatch() {
        List<Result> match = List.of(Result.MATCH, Result.MATCH, Result.MATCH, Result.MATCH, Result.MATCH);
        Results results = new Results(match);

        boolean result = results.isMatch();

        assertThat(result).isTrue();
    }

    @DisplayName("입력한 문자가 정답문자열과 일치하지 않으면 결과는 false를 반환한다.")
    @Test
    void isNotMatch() {
        List<Result> match = List.of(Result.MATCH, Result.EXIST, Result.MATCH, Result.MATCH, Result.MATCH);
        Results results = new Results(match);

        boolean result = results.isMatch();

        assertThat(result).isFalse();
    }
}