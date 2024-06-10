package wordle;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WordsTest {

    @DisplayName("주어진 날짜에 대한 단어를 얻는다.")
    @ParameterizedTest
    @MethodSource("provideLocalDateAndAnswer")
    void getWordOfDay(LocalDate localDate, String answer) {
        List<String> wordList = List.of("apple", "hello", "lemon");
        Words words = new Words(wordList, LocalDate.of(2021, 6, 19));

        String wordOfDay = words.getWordOfDay(localDate);

        Assertions.assertThat(wordOfDay).isEqualTo(answer);
    }

    public static Stream<Arguments> provideLocalDateAndAnswer() {
        return Stream.of(
            Arguments.of(LocalDate.of(2021, 6, 19), "apple"),
            Arguments.of(LocalDate.of(2021, 6, 20), "hello"),
            Arguments.of(LocalDate.of(2021, 6, 21), "lemon"),
            Arguments.of(LocalDate.of(2021, 6, 22), "apple")
        );
    }
}
