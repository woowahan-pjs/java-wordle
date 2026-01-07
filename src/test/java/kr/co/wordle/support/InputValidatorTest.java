package kr.co.wordle.support;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    void 입력_null() {
        Assertions.assertTrue(InputValidator.isNotValid(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "ant", "a"})
    void 입력_5자_아님(String input) {
        Assertions.assertTrue(InputValidator.isNotValid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"133ke", "아ddsz", "치즈&kr"})
    void 입력_알파벳_아님(String input) {
        Assertions.assertTrue(InputValidator.isNotValid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"woowa", "qwery", "zxcvb"})
    void 입력_단어파일에_없음(String input) {
        Assertions.assertTrue(InputValidator.isNotValid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"feign", "major", "death", "fresh"})
    void 입력_유효(String input) {
        Assertions.assertFalse(InputValidator.isNotValid(input));
    }
}
