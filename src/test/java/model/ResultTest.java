package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultTest {

    @ParameterizedTest
    @DisplayName("입력한 문자와 정답 문자 비교결과 확인")
    @CsvSource({"a,1,a,1,MATCH", "a,1,a,2,EXIST", "a,1,b,1,NON_EXIST"})
    void checkCompareResultInputCharacterAndAnswerCharacter(String value, int position, String otherValue,
                                                            int otherPosition, Result result) {
        Character character1 = new Character(value, position);
        Character character2 = new Character(otherValue, otherPosition);

        Result compareResult = Result.valueOf(character1, character2);

        assertThat(compareResult).isEqualTo(result);
    }
}