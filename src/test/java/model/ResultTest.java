package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultTest {

    @ParameterizedTest(name = "RESULT가 {0}면 mark는 {1}다")
    @CsvSource({"MATCH,🟩", "EXIST,🟨", "NON_EXIST,⬜"})
    void resultMark(Result result, String mark) {
        assertThat(result.getResultMark()).isEqualTo(mark);
    }
}