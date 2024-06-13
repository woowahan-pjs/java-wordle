package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import wordle.TimeTestSupporter;

public class BaseAnswerFormulaTest {

    private static final LocalDate mockedDate = LocalDate.of(2024, 6, 12);

    @ParameterizedTest
    @CsvSource(value = {"10:9", "100:89", "10000:1089"}, delimiter = ':')
    void 오늘의_정답_공식을_생성할_수_있다(int wordCount, long expected) {
        TimeTestSupporter.runWithMock(mockedDate, () -> {
            BaseAnswerFormula answerFormula = new BaseAnswerFormula();

            int index = answerFormula.calculate(wordCount);

            assertThat(index).isEqualTo(expected);
        });
    }
}
