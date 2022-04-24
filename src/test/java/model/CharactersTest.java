package model;

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
        List<Character> result = characters.getCharacters();

        assertThat(result).hasSize(5);
    }

    @DisplayName("5글자가 아니면 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"abcd", "abcdef"})
    void characterLengthValid(String input) {
        assertThatThrownBy(() -> {
            new Characters(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}