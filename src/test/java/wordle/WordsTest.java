package wordle;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import wordle.model.Words;

class WordsTest {

    @DisplayName("주어진 날짜에 대한 단어를 얻는다.")
    @ParameterizedTest
    @MethodSource("provideLocalDateAndAnswer")
    void getWordOfDay(LocalDate localDate, String answer) {
        // given
        Words words = new Words(
                List.of("apple", "hello", "lemon"),
                LocalDate.of(2021, 6, 19)
        );

        // when
        String wordOfDay = words.getWordOfDay(localDate);

        // then
        assertThat(wordOfDay).isEqualTo(answer);
    }

    public static Stream<Arguments> provideLocalDateAndAnswer() {
        return Stream.of(
            Arguments.of(LocalDate.of(2021, 6, 19), "apple"),
            Arguments.of(LocalDate.of(2021, 6, 20), "hello"),
            Arguments.of(LocalDate.of(2021, 6, 21), "lemon"),
            Arguments.of(LocalDate.of(2021, 6, 22), "apple")
        );
    }

    @DisplayName("입력한 단어의 포함 여부를 확인한다.")
    @ParameterizedTest
    @CsvSource({
        "organ, true",
        "apple, false"
    })
    void notContains(String input, boolean expected) {
        List<String> wordList = List.of("apple", "hello", "lemon");
        Words words = new Words(wordList, LocalDate.now());

        boolean notContains = words.notContains(input);

        assertThat(notContains).isEqualTo(expected);
    }
}
