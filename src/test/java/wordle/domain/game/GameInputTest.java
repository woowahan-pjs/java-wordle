package wordle.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class GameInputTest {

    @ParameterizedTest(name = "Input({0})")
    @DisplayName("Input 생성 및 조회")
    @CsvSource({
            "apple",
            "APPLE",
            "''",
            "12345"
    })
    void constructor_and_getValue(String value) {
        GameInput input = new GameInput(value);

        assertEquals(value, input.value());
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("null 값 허용")
    @NullSource
    void constructor_nullValue_allowed(String value) {
        GameInput input = new GameInput(value);

        assertNull(input.value());
    }

    @ParameterizedTest(name = "{0} = {1}: {2}")
    @DisplayName("equals 및 hashCode 검증")
    @CsvSource({
            "같은 값, apple, apple, true",
            "다른 값, apple, grape, false",
            "대소문자, apple, APPLE, false",
            "빈 문자열, '', '', true",
            "null, , , true"
    })
    void equals_and_hashCode(String description, String value1, String value2, boolean shouldBeEqual) {
        GameInput input1 = new GameInput(value1);
        GameInput input2 = new GameInput(value2);

        if (shouldBeEqual) {
            assertEquals(input1, input2, description);
            assertEquals(input1.hashCode(), input2.hashCode(), description + " hashCode");
        } else {
            assertNotEquals(input1, input2, description);
        }
    }

    @Test
    @DisplayName("null과 non-null은 동등하지 않음")
    void equals_nullAndNonNull_notEqual() {
        GameInput input1 = new GameInput(null);
        GameInput input2 = new GameInput("apple");

        assertNotEquals(input1, input2);
    }

    @Test
    @DisplayName("같은 객체는 동등함")
    void equals_sameObject_returnsTrue() {
        GameInput input = new GameInput("apple");

        assertEquals(input, input);
    }

    @Test
    @DisplayName("null 객체와 비교 시 false")
    void equals_null_returnsFalse() {
        GameInput input = new GameInput("apple");

        assertNotEquals(input, null);
    }

    @Test
    @DisplayName("다른 타입과 비교 시 false")
    void equals_differentType_returnsFalse() {
        GameInput input = new GameInput("apple");

        assertNotEquals(input, "apple");
    }

    @Test
    @DisplayName("불변성 보장")
    void immutability_test() {
        GameInput input = new GameInput("apple");

        String value1 = input.value();
        String value2 = input.value();

        assertSame(value1, value2);
        assertEquals("apple", value1);
    }
}
