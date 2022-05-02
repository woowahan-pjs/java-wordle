package wordle.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("`Wordle` 객체 테스트")
class WordleTest {

    @DisplayName("TargetWord 넘겨 받는 경우 `Wordle` 객체 생성 성공")
    @Test
    void createNewWordleTestGivenTargetWord() {
        // Arrange
        final Wordle wordle = new Wordle("alike");

        // Act
        // Assert
        assertThat(wordle.isContinue()).isTrue();
    }

    @DisplayName("TargetWord 넘겨 받지 않는 경우 `Wordle` 객체 생성 실패")
    @Test
    void createNewWordleTestNotGivenTargetWord() {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy(() -> {
            new Wordle("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("TargetWord는 필수입니다.");
    }
}