package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import wordle.TimeTestSupporter;
import wordle.exception.AnswerFormulaWordCountException;

public class BaseAnswerFormulaTest {

    @ParameterizedTest
    @CsvSource(value = {"10:9", "100:89", "10000:1089"}, delimiter = ':')
    void 오늘의_정답_공식을_생성할_수_있다(int wordCount, long expected) {
        TimeTestSupporter.runWithMock(TimeTestSupporter.mockedDate, () -> {
            BaseAnswerFormula answerFormula = new BaseAnswerFormula();

            int index = answerFormula.calculate(wordCount);

            assertThat(index).isEqualTo(expected);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 파라미터는_1보다_작을_수_없다(int wordCount) {
        BaseAnswerFormula answerFormula = new BaseAnswerFormula();

        assertThatThrownBy(() -> answerFormula.calculate(wordCount))
                .isInstanceOf(AnswerFormulaWordCountException.class);
    }
}
