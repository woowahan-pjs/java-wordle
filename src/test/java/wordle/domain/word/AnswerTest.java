package wordle.domain.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    @DisplayName("null 입력 시 예외 발생")
    void constructor_nullValue_throwsException() {
        assertThrows(NullPointerException.class, () -> new Answer(null));
    }

    @ParameterizedTest(name = "{0} = {1}: {2}")
    @DisplayName("equals 및 hashCode 검증")
    @CsvSource({
            "같은 값, apple, apple, true",
            "다른 값, apple, grape, false",
            "대소문자, apple, APPLE, false",
            "빈 문자열, '', '', true"
    })
    void equals_and_hashCode(String description, String value1, String value2, boolean shouldBeEqual) {
        Answer answer1 = new Answer(value1);
        Answer answer2 = new Answer(value2);

        if (shouldBeEqual) {
            assertEquals(answer1, answer2, description);
            assertEquals(answer1.hashCode(), answer2.hashCode(), description + " hashCode");
        } else {
            assertNotEquals(answer1, answer2, description);
        }
    }

    @Test
    @DisplayName("같은 객체는 동등함")
    void equals_sameObject_returnsTrue() {
        Answer answer = new Answer("apple");

        assertEquals(answer, answer);
    }

    @Test
    @DisplayName("null과 비교 시 false")
    void equals_null_returnsFalse() {
        Answer answer = new Answer("apple");

        assertNotEquals(answer, null);
    }

    @Test
    @DisplayName("다른 타입과 비교 시 false")
    void equals_differentType_returnsFalse() {
        Answer answer = new Answer("apple");

        assertNotEquals(answer, "apple");
    }

    @Test
    @DisplayName("불변성 보장")
    void immutability_test() {
        Answer answer = new Answer("apple");

        String value1 = answer.value();
        String value2 = answer.value();

        assertSame(value1, value2);
        assertEquals("apple", value1);
    }
}
