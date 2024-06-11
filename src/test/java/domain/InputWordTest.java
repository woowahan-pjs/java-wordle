package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class InputWordTest {

    private List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");

    @Test
    @DisplayName("입력단어 유효성 검증 성공 테스트")
    void validateSuccessInputWord() {
        assertDoesNotThrow(() -> new InputWord("date", words));

    }


    @Test
    @DisplayName("입력단어 유효성 검증 실패 테스트")
    void validateFailInputWord() {
        assertThrows(IllegalArgumentException.class,() -> new InputWord("pangyo", words));
    }

}
