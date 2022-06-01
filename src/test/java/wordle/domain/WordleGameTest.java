package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static wordle.domain.BingoStatus.*;

@DisplayName("Wordle 게임의 비교 기능을 처리하는 `WordleGame` 객체 테스트")
class WordleGameTest {

    @DisplayName("`goalWord`가 주어진 경우 `WordleGame` 객체 생성 성공")
    @Test
    void createWordleGameIsSuccessIfGivenWord() {
        // Arrange
        final Word goalWord = new Word("Apple");

        // Act
        final WordleGame wordleGame = new WordleGame(goalWord);

        // Assert
        assertThat(wordleGame.getBingoRecords()).isEqualTo(List.of());
    }

    @DisplayName("`Word`가 주어지면 `WordleGame`의 `GoalWord`와 비교하여 결과 반환")
    @ParameterizedTest(name = "[{index}] -> goalWord: {0}, givenWord: {1}, expectedRecord: {2}")
    @MethodSource("goalWordAndGivenWordAndExpectedStatuses")
    void returnBingoStatusesIfCompareToMatch(Word goalWord, Word givenWord, BingoRecord expectedRecord) {
        // Arrange
        final WordleGame wordleGame = new WordleGame(goalWord);

        // Act
        wordleGame.compareToMatch(givenWord);

        // Assert
        assertThat(wordleGame.getBingoRecords().get(0)).isEqualTo(expectedRecord);
    }

    @DisplayName("주어진 `Word`와 `WordleGame`의 `GoalWord`와 비교하여 동일한 경우 `isAllMatch` 함수는 `true` 반환")
    @ParameterizedTest(name = "[{index}] -> sameWord: {0}")
    @ValueSource(strings = {"apple", "metro", "petal", "legal"})
    void returnTrueIfGivenWordIsEqualToGoalWord(String sameWord) {
        // Arrange
        final Word givenWord = new Word(sameWord);
        final Word goalWord = new Word(sameWord);
        final WordleGame wordleGame = new WordleGame(goalWord);

        // Act
        wordleGame.compareToMatch(givenWord);

        // Assert
        assertThat(wordleGame.isAllMatch()).isTrue();
    }

    @DisplayName("주어진 `Word`와 `WordleGame`의 `GoalWord`와 비교하여 동일하지 않는 경우 `isAllMatch` 함수는 `false` 반환")
    @ParameterizedTest(name = "[{index}] -> goalString: {0}, givenString: {1}")
    @CsvSource(value = {"apple:happy", "hairy:happy", "petal:fetal", "legal:regal"}, delimiter = ':')
    void returnFalseIfGivenWordIsNopEqualToGoalWord(String goalString, String givenString) {
        // Arrange
        final Word givenWord = new Word(givenString);
        final Word goalWord = new Word(goalString);
        final WordleGame wordleGame = new WordleGame(goalWord);

        // Act
        wordleGame.compareToMatch(givenWord);

        // Assert
        assertThat(wordleGame.isAllMatch()).isFalse();
    }

    private static Stream<Arguments> goalWordAndGivenWordAndExpectedStatuses() {
        return Stream.of(
            Arguments.of(
                new Word("apple"),
                new Word("ApplE"),
                new BingoRecord(List.of(NOTHING, MATCH, MATCH, MATCH, NOTHING))
            ),
            Arguments.of(
                new Word("hairy"),
                new Word("happy"),
                new BingoRecord(List.of(MATCH, MATCH, NOTHING, NOTHING, MATCH))
            ),
            Arguments.of(
                new Word("glass"),
                new Word("class"),
                new BingoRecord(List.of(NOTHING, MATCH, MATCH, MATCH, MATCH))
            ),
            Arguments.of(
                new Word("upper"),
                new Word("lower"),
                new BingoRecord(List.of(NOTHING, NOTHING, NOTHING, MATCH, MATCH))
            ),
            Arguments.of(
                new Word("meter"),
                new Word("metro"),
                new BingoRecord(List.of(MATCH, MATCH, MATCH, CONTAIN, NOTHING))
            ),
            Arguments.of(
                new Word("camel"),
                new Word("melon"),
                new BingoRecord(List.of(CONTAIN, CONTAIN, CONTAIN, NOTHING, NOTHING))
            )
        );
    }
}
