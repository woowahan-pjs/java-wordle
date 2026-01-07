package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class LetterTest {

    @DisplayName("Letter 을 생성한다.")
    @Test
    void test01() {
        Letter letter = new Letter('A');

        assertThat(letter.getLetter()).isEqualTo("A");
    }

    @DisplayName("Letter 에 숫자가 들어가면 에러가 발생한다.")
    @Test
    void test02() {
        assertThatThrownBy(() -> new Letter('1')).isInstanceOf(IllegalArgumentException.class);
    }
}