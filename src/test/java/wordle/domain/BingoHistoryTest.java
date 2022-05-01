package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static wordle.domain.BingoStatus.CONTAIN;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("정답 여부 기록을 담당하는 `BingoHistory` 객체 태스트")
class BingoHistoryTest {

    @DisplayName("`BingoHistory` 객체에 정답 여부 기록을 최대 5번까지 추가 가능")
    @Test
    void canAddBingoHistoryWhenNumberOfHistoryAddIsLessThanFive() {
        // Arrange
        final BingoHistory history = new BingoHistory();

        // Act
        for (int i = 0; i < 5; i++) {
            history.add(CONTAIN);
        }

        // Assert
        assertThat(history.getHistory()).containsExactlyElementsOf(
                List.of(CONTAIN, CONTAIN, CONTAIN, CONTAIN, CONTAIN));
    }

    @DisplayName("`BingoHistory` 객체에 정답 여부 기록을 5번이상 추가하는 경우 예외 발생")
    @Test
    void canNotAddBingoHistoryWhenNumberOfHistoryAddIsEqualsToFiveOrGreaterThanFive() {
        // Arrange
        final BingoHistory history = new BingoHistory();

        // Act
        // Assert
        assertThatThrownBy(() -> {
            for (int i = 0; i < 6; i++) {
                history.add(CONTAIN);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }
}