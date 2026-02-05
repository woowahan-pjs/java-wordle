package wordle.domain.game.validation;

import wordle.domain.word.WordRepository;
import wordle.infrastructure.persistence.FileWordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setUp() {
        WordRepository wordRepository = new FileWordRepository();
        validator = new InputValidator(wordRepository);
    }

    @ParameterizedTest(name = "유효한 입력: {0}")
    @DisplayName("유효한 입력 검증")
    @ValueSource(strings = { "apple", "APPLE", "ApPlE", "grape", "train" })
    void check_validInputs(String input) {
        ValidationStatus result = validator.check(input);

        assertEquals(ValidationStatus.VALID, result);
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("null 입력")
    @NullSource
    void check_nullInput(String input) {
        ValidationStatus result = validator.check(input);

        assertEquals(ValidationStatus.NULL_INPUT, result);
    }

    @ParameterizedTest(name = "길이 {0}: ''{1}''")
    @DisplayName("잘못된 길이")
    @CsvSource({
            "너무 짧음, a",
            "너무 짧음, app",
            "너무 짧음, appl",
            "빈 문자열, ''",
            "너무 김, apples",
            "너무 김, application"
    })
    void check_invalidLength(String description, String input) {
        ValidationStatus result = validator.check(input);

        assertEquals(ValidationStatus.INVALID_LENGTH, result, description);
    }

    @ParameterizedTest(name = "{0}: ''{1}''")
    @DisplayName("알파벳이 아닌 문자")
    @CsvSource({
            "숫자 포함, appl1",
            "숫자만, 12345",
            "특수문자, app!e",
            "공백 포함, ap le",
            "특수문자만, @#$%^",
            "한글, 사과과과과",
            "한글+영어, app사과"
    })
    void check_notAlphabet(String description, String input) {
        ValidationStatus result = validator.check(input);

        assertEquals(ValidationStatus.NOT_ALPHABET, result, description);
    }

    @ParameterizedTest(name = "사전에 없는 단어: {0}")
    @DisplayName("사전에 없는 단어")
    @ValueSource(strings = { "zzzzz", "xqxqx", "qwxyz", "bbbbb" })
    void check_notInDictionary(String input) {
        ValidationStatus result = validator.check(input);

        assertEquals(ValidationStatus.NOT_IN_DICTIONARY, result);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @DisplayName("검증 우선순위 확인")
    @CsvSource({
            "null 우선, , NULL_INPUT",
            "길이 > 알파벳, 123, INVALID_LENGTH",
            "알파벳 > 사전, @####, NOT_ALPHABET"
    })
    void check_checkOrder(String description, String input, ValidationStatus expected) {
        ValidationStatus result = validator.check(input);

        assertEquals(expected, result, description + " 검증");
    }
}
