package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WordTest {

    @DisplayName("입력 받은 문자열은 5글자이야 한다.")
    @Test
    void wordLengthValid() {
        Word word = Word.create("abcde");

        assertThat(word).isNotNull();
        assertThat(word.length()).isEqualTo(5);
    }

    @DisplayName("입력 받은 문자열의 길이가 5글자가 아닌 경우, 예외처리")
    @Test
    void wordLengthNotFiveException() {
        assertThatThrownBy(() -> Word.create("abce"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Word.create("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}