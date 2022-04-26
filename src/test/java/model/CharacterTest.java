package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CharacterTest {

    @DisplayName("문자는 영어로 생성할 수 있다.")
    @ParameterizedTest(name = "문자는 영어로 생성할 수 있다.")
    @ValueSource(strings = {"A", "Z", "a", "z"})
    void englishValid(String c) {
        Character character = new Character(c);
        assertThat(character).isNotNull();
    }

    @DisplayName("영어 이외 문자가 들어가면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"1", " ", "$"})
    void characterIsNotNumber(String input) {
        assertThatThrownBy(() -> new Character(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 문자와 정답 문자가 같은지 비교")
    @ParameterizedTest
    @CsvSource({"a,b,-1", "a,a,0", "b,a,1"})
    void wordAndAnswerCharacterCompare(String value, String otherValue, int expected) {
        Character character1 = new Character(value);
        Character character2 = new Character(otherValue);

        assertThat(character1.compareTo(character2)).isEqualTo(expected);
    }

    @DisplayName("소문자, 대문자를 구분 하지 않는다.")
    @Test
    void NotCompareLowerCaseAndUpperCase() {
        Character character1 = new Character("a");
        Character character2 = new Character("A");
        int expected = 0;

        assertThat(character1.compareTo(character2)).isEqualTo(expected);
    }

    @DisplayName("단어의 위치값을 확인한다.")
    @Test
    void checkWordPosition() {
        Character character = new Character("a", 0);

        assertThat(character.getPosition()).isEqualTo(0);
    }

    @DisplayName("문자가 동일하고 같은 위치에 있으면 match, 문자만 동일하면 exist, 둘다 동일하지 않으면 nonExist")
    @ParameterizedTest
    @CsvSource({"a,1,b,1,NON_EXIST", "a,1,a,1,MATCH", "a,1,a,2,EXIST"})
    void checkPositionAndValue(String value1, int position, String value2, int position2, Result result) {
        Character input = new Character(value1, position);
        Character answer = new Character(value2, position2);

        //match , exist , nonExist
        assertThat(input.isSame(answer)).isEqualTo(result);
    }
}