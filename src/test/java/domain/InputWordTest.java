package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class InputWordTest {
    @DisplayName("입력단어 유효성 검증 성공 테스트")
    void validateSuccessInputWord() {
        List<String> words = List.of("apples", "cherry");
        assertDoesNotThrow(() -> new InputWord("cherry", words));

    }


    @Test
    @DisplayName("입력단어 유효성 검증 실패 테스트")
    void
    validateFailInputWord() {
        List<String> words = List.of("apples", "banana");
        assertThrows(IllegalArgumentException.class,() -> new InputWord("pangyo", words));
    }

    @Test
    @DisplayName("입력단어 글자수 유효성 검증 실패 테스트")
    void validateInputWordLength() {
        List<String> words = List.of("apple", "abcdef");
        assertThrows(IllegalArgumentException.class,() -> new InputWord("abcdef", words));
    }


    @Test
    @DisplayName("입력단어 영단어 유효성 검증 실패 테스트")
    void validateInputWordOnlyEnglish() {
        List<String> words = List.of("apple", "abcd1", "안녕하세요");

        assertAll(
                () -> assertThrows(IllegalArgumentException.class,() -> new InputWord("abcd1", words)),
                () -> assertThrows(IllegalArgumentException.class,() -> new InputWord("안녕하세요", words))
        );
    }


}
