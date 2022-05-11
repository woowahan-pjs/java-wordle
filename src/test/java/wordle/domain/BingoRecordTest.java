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

@DisplayName("정답 여부 기록을 담당하는 `BingoRecord` 객체 태스트")
class BingoRecordTest {
    private final List<BingoStatus> allContainStatuses = List.of(CONTAIN, CONTAIN, CONTAIN, CONTAIN, CONTAIN, CONTAIN);

    @DisplayName("정답 여부 리스트가 주어지면 `BingoRecord` 객체 생성 성공")
    @ParameterizedTest
    @MethodSource("bingoStatuses")
    void createBingoRecordIsSuccessGivenBingoStatuses(List<BingoStatus> bingoStatuses) {
        // Arrange
        // Act
        final BingoRecord record = new BingoRecord(bingoStatuses);

        // Assert
        assertThat(record.getRecord()).containsExactlyElementsOf(bingoStatuses);
    }

    @DisplayName("주어진 정답 여부 리스트가 변경되어도 `BingoRecord` 객체 내 정답 여부 리스트는 초기 상태 유지")
    @Test
    void bingoRecordIsImmutableEvenIfGivenBingoStatusesAreChanged() {
        // Arrange
        final List<BingoStatus> mutableBingoStatuses = new ArrayList<>(allContainStatuses);

        final BingoRecord record = new BingoRecord(mutableBingoStatuses);
        final List<BingoStatus> originRecord = record.getRecord();

        // Act
        mutableBingoStatuses.set(0, NOTHING);
        mutableBingoStatuses.set(1, NOTHING);
        mutableBingoStatuses.set(2, NOTHING);
        mutableBingoStatuses.set(3, NOTHING);
        mutableBingoStatuses.set(4, NOTHING);

        // Assert
        assertThat(record.getRecord()).containsExactlyElementsOf(originRecord);
    }

    @DisplayName("`BingoRecord` 객체가 반환하는 정답 여부 리스트는 변경 불가")
    @Test
    void throwExceptionIfYouTryToChangedTheReturnBingoStatuses() {
        // Arrange
        final List<BingoStatus> originBingoStatuses = allContainStatuses;

        // Act
        // Assert
        assertThatThrownBy(() -> {
            final List<BingoStatus> recordedBingoStatuses = new BingoRecord(originBingoStatuses).getRecord();
            recordedBingoStatuses.set(0, NOTHING);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("주어진 단어가 타겟 단어와 스펠링이 모두 일치하는 경우 `true` 반환")
    @Test
    void returnTrueWhenWordIsExactlyMatchStatus() {
        // Arrange
        final BingoRecord allMatchStatusRecord = new BingoRecord(List.of(MATCH, MATCH, MATCH, MATCH, MATCH));

        // Act
        final boolean resultAllMatchStatus = allMatchStatusRecord.isAllMatch();

        // Assert
        assertThat(resultAllMatchStatus).isTrue();
    }

    @DisplayName("주어진 단어가 타겟 단어와 스펠링이 모두 일치하지 않는 경우 `false` 반환")
    @ParameterizedTest
    @MethodSource("isNotAllMatchStatuses")
    void returnFalseWhenWordIsNotExactlyMatchStatus(List<BingoStatus> isNotAllMatchStatuses) {
        // Arrange
        final BingoRecord isNotAllMatchStatusRecord = new BingoRecord(isNotAllMatchStatuses);

        // Act
        final boolean resultAllMatchStatus = isNotAllMatchStatusRecord.isAllMatch();

        // Assert
        assertThat(resultAllMatchStatus).isFalse();
    }

    private static Stream<Arguments> bingoStatuses() {
        return Stream.of(
            Arguments.of(List.of(MATCH, MATCH, MATCH, MATCH, MATCH)),
            Arguments.of(List.of(CONTAIN, CONTAIN, CONTAIN, CONTAIN, CONTAIN)),
            Arguments.of(List.of(MATCH, CONTAIN, MATCH, NOTHING, MATCH)),
            Arguments.of(List.of(CONTAIN, NOTHING, MATCH, NOTHING, CONTAIN)),
            Arguments.of(List.of(NOTHING, NOTHING, MATCH, MATCH, CONTAIN))
        );
    }

    private static Stream<Arguments> isNotAllMatchStatuses() {
        return Stream.of(
            Arguments.of(List.of(CONTAIN, CONTAIN, CONTAIN, CONTAIN, CONTAIN)),
            Arguments.of(List.of(NOTHING, NOTHING, NOTHING, NOTHING, NOTHING)),
            Arguments.of(List.of(MATCH, MATCH, MATCH, MATCH, CONTAIN)),
            Arguments.of(List.of(MATCH, MATCH, MATCH, MATCH, NOTHING)),
            Arguments.of(List.of(CONTAIN, MATCH, CONTAIN, NOTHING, MATCH)),
            Arguments.of(List.of(NOTHING, NOTHING, MATCH, MATCH, CONTAIN))
        );
    }
}
