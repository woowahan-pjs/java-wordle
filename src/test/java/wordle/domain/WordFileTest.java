package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("단어 목록 파일을 읽어서 정답을 반환하는 `WordFile` 객체 테스트")
public class WordFileTest {

    @DisplayName("존재하는 파일을 넘겨 받는 경우 `WordFile` 객체 생성 성공")
    @Test
    void createWordFileIsSuccessGivenExistFileName() {
        // Arrange
        // Act
        // Assert
        new WordFile("words.txt");
    }

    @DisplayName("존재하지 않는 파일을 넘겨 받는 경우 `WordFile` 객체 생성 실패")
    @Test
    void createWordFileIsFailGivenNotExistFileName() {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy(() -> {
            new WordFile("notExistWords.txt");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 파일이 필요합니다.");
    }

    @DisplayName("스캔한 단어 목록 파일에서 목표 단어 추출하여 반환")
    @ParameterizedTest
    @MethodSource("givenValidDateAndExpectedTargetWord")
    void returnTargetWordIsSuccessGivenDate(LocalDate targetDate, String expectedTargetWord) {
        // Arrange
        final WordFile wordFile = new WordFile("words.txt");

        // Act
        final String foundTargetWord = wordFile.findTargetWord(targetDate);

        // Assert
        assertThat(foundTargetWord).isEqualTo(expectedTargetWord);
    }

    static Stream<Arguments> givenValidDateAndExpectedTargetWord() {
        return Stream.of(
                Arguments.of(LocalDate.of(2022, 5, 1), "trash"),
                Arguments.of(LocalDate.of(2022, 5, 2), "fella"),
                Arguments.of(LocalDate.of(2022, 3, 17), "movie"),
                Arguments.of(LocalDate.of(1988, 7, 16), "soggy"),
                Arguments.of(LocalDate.of(1980, 1, 1), "stern"),
                Arguments.of(LocalDate.of(2050, 12, 13), "wield"),
                Arguments.of(LocalDate.of(2079, 4, 8), "tipsy")
        );
    }
}
