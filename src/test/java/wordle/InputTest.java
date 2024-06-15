package wordle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputTest {

    @DisplayName("입력한 단어의 길이가 주어진 길이보다 작으면 true")
    @ParameterizedTest
    @CsvSource({"5, false", "6, true", "4, false"})
    void lessThan(int length, boolean result) {
        Input input = new Input("apple");

        boolean lessThan = input.lessThan(length);

        assertThat(lessThan).isEqualTo(result);
    }
}
