package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class InputWordTest {
    @Test
    @DisplayName("단어 생성 성공 테스트")
    void validateSuccessInputWord() {
        assertDoesNotThrow(() -> new Word("apple"));
    }

    @Test
    @DisplayName("입력단어 글자수 유효성 검증 실패 테스트")
    void validateInputWordLength() {
        assertThrows(IllegalArgumentException.class,() -> new Word("abcdef"));
    }


    @Test
    @DisplayName("입력단어 영단어 유효성 검증 실패 테스트")
    void validateInputWordOnlyEnglish() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,() -> new Word("abcd1")),
                () -> assertThrows(IllegalArgumentException.class,() -> new Word("안녕하세요"))
        );
    }
}
