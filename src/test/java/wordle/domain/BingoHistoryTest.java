package wordle.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static wordle.domain.BingoStatus.CONTAIN;
import static wordle.domain.BingoStatus.MATCH;
import static wordle.domain.BingoStatus.NOTHING;

@DisplayName("정답 여부 기록을 담당하는 `BingoHistory` 객체 태스트")
class BingoHistoryTest {

    @DisplayName("정답 여부 리스트가 주어지면 `BingoHistory` 객체 생성 성공")
    @ParameterizedTest
    @MethodSource("bingoHistoryList")
    void createBingoHistoryIsSuccessGivenBingoStatusList(List<BingoStatus> bingoHistoryList) {
        // Arrange
        // Act
        final BingoHistory history = new BingoHistory(bingoHistoryList);

        // Assert
        assertThat(history.getHistory()).containsExactlyElementsOf(bingoHistoryList);
    }

    @DisplayName("주어진 정답 여부 리스트가 변경되어도 `BingoHistory` 객체 내 정답 여부 리스트는 초기 상태 유지")
    @Test
    void BingoHistoryIsImmutableEvenIfGivenBingoStatusListIsChanged() {
        // Arrange
        final List<BingoStatus> mutableBingoHistory = new ArrayList<>();
        mutableBingoHistory.add(CONTAIN);
        mutableBingoHistory.add(CONTAIN);
        mutableBingoHistory.add(CONTAIN);
        mutableBingoHistory.add(CONTAIN);
        mutableBingoHistory.add(CONTAIN);

        final BingoHistory history = new BingoHistory(mutableBingoHistory);
        final List<BingoStatus> originHistory = history.getHistory();

        // Act
        mutableBingoHistory.set(0, NOTHING);
        mutableBingoHistory.set(1, NOTHING);
        mutableBingoHistory.set(2, NOTHING);
        mutableBingoHistory.set(3, NOTHING);
        mutableBingoHistory.set(4, NOTHING);

        // Assert
        assertThat(history.getHistory()).containsExactlyElementsOf(originHistory);
    }

    @DisplayName("`BingoHistory` 객체가 반환하는 정답 여부 리스트는 변경 불가")
    @Test
    void throwExceptionIfYouTryToChangedTheReturnBingoStatusList() {
        // Arrange
        final List<BingoStatus> bingoHistory = new ArrayList<>();
        bingoHistory.add(CONTAIN);
        bingoHistory.add(CONTAIN);
        bingoHistory.add(CONTAIN);
        bingoHistory.add(CONTAIN);
        bingoHistory.add(CONTAIN);

        // Act
        // Assert
        assertThatThrownBy(() -> {
            final List<BingoStatus> bingoStatusList = new BingoHistory(bingoHistory).getHistory();
            bingoStatusList.set(0, NOTHING);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    private static Stream<Arguments> bingoHistoryList() {
        return Stream.of(
            Arguments.of(List.of(MATCH, MATCH, MATCH, MATCH, MATCH)),
            Arguments.of(List.of(CONTAIN, CONTAIN, CONTAIN, CONTAIN, CONTAIN)),
            Arguments.of(List.of(MATCH, CONTAIN, MATCH, NOTHING, MATCH)),
            Arguments.of(List.of(CONTAIN, NOTHING, MATCH, NOTHING, CONTAIN)),
            Arguments.of(List.of(NOTHING, NOTHING, MATCH, MATCH, CONTAIN))
        );
    }
}
