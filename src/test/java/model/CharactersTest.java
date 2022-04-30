package model;

import static model.Characters.OUT_OF_WORD_LENGTH_ERR_MSG;
import static model.Result.EXIST;
import static model.Result.MATCH;
import static model.Result.NON_EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CharactersTest {

    @DisplayName("입력 받은 문자열은 5글자이야 한다.")
    @Test
    void characterGroupLengthFive() {
        Characters characters = new Characters("abcde");
        List<Character> result = characters.convertToList();

        assertThat(result).hasSize(5);
    }

    @ParameterizedTest(name = "5글자가 아닌 입력문자 {0}를 입력하면 에외처리")
    @ValueSource(strings = {"abcd", "abcdef"})
    void characterLengthValid(String input) {
        assertThatThrownBy(() -> {
            new Characters(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_WORD_LENGTH_ERR_MSG);
    }

    @DisplayName("입력 받은 문자열과 정답 문자열을 비교한다.")
    @Test
    void matchCharacters() {
        Characters input = new Characters("abcde");
        Characters answer = new Characters("abeee");

        Results result = input.match(answer);

        assertThat(result.convertToList()).containsExactly(MATCH, MATCH, NON_EXIST, NON_EXIST,
                MATCH);
    }

    @DisplayName("입력 받은 문자열과 정답 문자열을 비교한다.(포함되지만 위치가 다른 문자가 존재하는 경우)")
    @Test
    void matchCharacters2() {
        Characters input = new Characters("abcde");
        Characters answer = new Characters("abece");

        Results result = input.match(answer);

        assertThat(result.convertToList()).containsExactly(MATCH, MATCH, EXIST, NON_EXIST, MATCH);
    }

    @DisplayName("입력 받은 문자열과 정답 문자열이 모두 일치한다.")
    @Test
    void matchCharacters3() {
        Characters input = new Characters("abcde");
        Characters answer = new Characters("abcde");

        Results result = input.match(answer);

        assertThat(result.convertToList()).containsExactly(MATCH, MATCH, MATCH, MATCH, MATCH);
    }

    @DisplayName("입력받은 문자열에 동일한 문자가 존재하고 정답 문자열에는 해당 문자가 한개만 매칭되는 경우")
    @Test
    void matchDuplicationInputCharacter1() {
        Characters input = new Characters("abcee");
        Characters answer = new Characters("gtyre");

        Results result = input.match(answer);

        assertThat(result.convertToList()).containsExactly(NON_EXIST, NON_EXIST, NON_EXIST, NON_EXIST,
                MATCH);
    }

    @DisplayName("입력받은 문자열에 동일한 문자가 존재하고 정답 문자열에는 해당 문자가 한개만 존재하는 경우")
    @Test
    void matchDuplicationInputCharacter2() {
        Characters input = new Characters("abcbd");
        Characters answer = new Characters("gtbre");

        Results result = input.match(answer);

        assertThat(result.convertToList()).containsExactly(NON_EXIST, EXIST, NON_EXIST, NON_EXIST,
                NON_EXIST);
    }

    @DisplayName("입력받은 문자열에 동일한 문자가 존재하고 정답 문자열에는 해당 문자가 하나는 매칭되고 하나는 존재하는 경우")
    @Test
    void matchDuplicationInputCharacter3() {
        Characters input = new Characters("abcee");
        Characters answer = new Characters("gtere");

        Results result = input.match(answer);

        assertThat(result.convertToList()).containsExactly(NON_EXIST, NON_EXIST, NON_EXIST, EXIST,
                MATCH);
    }

    @DisplayName("입력받은 문자열에 동일한 문자가 존재하고 정답 문자열에는 해당 문자가 존재하지 않는 경우")
    @Test
    void matchDuplicationInputCharacter4() {
        Characters input = new Characters("abcee");
        Characters answer = new Characters("gtqrq");

        Results result = input.match(answer);

        assertThat(result.convertToList()).containsExactly(NON_EXIST, NON_EXIST, NON_EXIST, NON_EXIST,
                NON_EXIST);
    }

    @DisplayName("정답 문자열에는 해당 문자가 두개이면서 입력문자열에 매칭되는 문자가 한개일 경우")
    @Test
    void matchDuplicationInputCharacter5() {
        Characters input = new Characters("abcbe");
        Characters answer = new Characters("gtere");

        Results result = input.match(answer);

        assertThat(result.convertToList()).containsExactly(NON_EXIST, NON_EXIST, NON_EXIST, NON_EXIST,
                MATCH);
    }
}