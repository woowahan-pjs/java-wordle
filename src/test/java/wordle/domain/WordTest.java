package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WordTest {

    @DisplayName("5글자 문자열이 주어진 경우 `Word` 객체 생성 성공")
    @ParameterizedTest
    @ValueSource(strings = {"APPLE", "SCALE", "HAPPY", "white", "dress", "phone", "pepsi"})
    void createWordIsSuccessIfGivenWordLengthIsFive(String givenWord) {
        // Arrange
        // Act
        final Word word = new Word(givenWord);

        // Assert
        assertThat(word.getWord()).isEqualTo(givenWord);
    }

    @DisplayName("Null 문자열이 주어진 경우 `Word` 객체 생성 실패")
    @ParameterizedTest
    @NullSource
    void createWordIsFailIfGivenWordIsNull(String givenWord) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy(() ->
            new Word(givenWord)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효하지 않은 단어 문자열 입니다.");
    }

    @DisplayName("5글자가 아닌 문자열이 주어진 경우 `Word` 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"", "S", "HA", "sun", "Next", "Kotlin", "happy new year"})
    void createWordIsFailIfGivenWordLengthIsNotEqualToFive(String givenWord) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy(() ->
            new Word(givenWord)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효하지 않은 단어 문자열 입니다.");
    }
}
