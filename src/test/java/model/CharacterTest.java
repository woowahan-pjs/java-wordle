package model;

import static model.Character.ILLEGAL_INPUT_ERR_MSG;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CharacterTest {

    @ParameterizedTest(name = "알파벳 {0} 는 Character를 생성할 수 있다.")
    @ValueSource(strings = {"A", "Z", "a", "z"})
    void englishValid(String c) {
        Character character = new Character(c);
        assertThat(character).isNotNull();
    }

    @ParameterizedTest(name = "영어 이외 문자 {0} 가 들어가면 예외처리")
    @ValueSource(strings = {"1", " ", "$"})
    void characterIsNotNumber(String input) {
        assertThatThrownBy(() -> new Character(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ILLEGAL_INPUT_ERR_MSG, input));
    }

    @ParameterizedTest(name = "입력 문자 {0} 와 정답 문자 {1}를 비교하면 {2}가 결과로 나타난다.")
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

    //"문자가 동일하고 같은 위치에 있으면 MATCH, 문자만 동일하면 EXIST, 둘다 동일하지 않으면 NON_EXIST"
    @ParameterizedTest(name = "입력 문자 {0}와 정답문자 {2}를 비교하고 입력문자 위치 {1}와 정답문자 위치 {3}을 비교하면 {4}가 결과로 나타난다.")
    @CsvSource({"a,1,b,1,NON_EXIST", "a,1,a,1,MATCH", "a,1,a,2,EXIST"})
    void checkPositionAndValue(String value1, int position, String value2, int position2, Result result) {
        Character input = new Character(value1, position);
        Character answer = new Character(value2, position2);

        //match , exist , nonExist
        assertThat(input.isSame(answer)).isEqualTo(result);
    }
}