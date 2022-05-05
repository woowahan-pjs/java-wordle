package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static wordle.domain.BingoStatus.*;

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

    @DisplayName("주어진 `Word`가 타겟 `Word`와 일치하는 지 비교하면 비교 결과를 리스트에 담아 반환")
    @ParameterizedTest
    @MethodSource("givenWordsAndTargetWordsAndExpectedBingoStatusList")
    void returnBingoStatusListWhenCompareBetweenGivenWordAndTargetWord(Word targetWord, Word givenWord, List<BingoStatus> expectedResult) {
        // Arrange
        // Act
        final List<BingoStatus> result = targetWord.compare(givenWord);

        // Assert
        assertThat(result.size()).isEqualTo(targetWord.getWord().length());
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> givenWordsAndTargetWordsAndExpectedBingoStatusList() {
        return Stream.of(
            Arguments.of(new Word("happy"), new Word("apple"), List.of(CONTAIN, CONTAIN, MATCH, NOTHING, NOTHING)),
            Arguments.of(new Word("heath"), new Word("melon"), List.of(NOTHING, MATCH, NOTHING, NOTHING, NOTHING)),
            Arguments.of(new Word("gamma"), new Word("trust"), List.of(NOTHING, NOTHING, NOTHING, NOTHING, NOTHING)),
            Arguments.of(new Word("break"), new Word("bread"), List.of(MATCH, MATCH, MATCH, MATCH, NOTHING)),
            Arguments.of(new Word("sonic"), new Word("conic"), List.of(CONTAIN, MATCH, MATCH, MATCH, MATCH)),
            Arguments.of(new Word("track"), new Word("tract"), List.of(MATCH, MATCH, MATCH, MATCH, CONTAIN)),
            Arguments.of(new Word("state"), new Word("state"), List.of(MATCH, MATCH, MATCH, MATCH, MATCH))
        );
    }
}
