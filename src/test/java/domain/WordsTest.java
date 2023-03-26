package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WordsTest {

    @DisplayName("Word 를 생성한다.")
    @Test
    void test01() {
        Words words = new Words(List.of("MySQL", "SLiPP"));

        assertThat(words.getWords()).containsExactly("MySQL", "SLiPP");
    }

    @DisplayName("파일에서 문자와 숫자가 섞인 Words 를 읽어온다.")
    @Test
    void test02() {
        Words words = new Words(List.of("MySQL", "cake", "12345"));

        assertThat(words.getWords()).containsExactly("MySQL");
    }

    @DisplayName("파일에서 빈 Words 를 읽어온다.")
    @Test
    void test03() {
        assertThatThrownBy(() -> new Words(Collections.emptyList()))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("파일에서 5글자가 아닌 Words 를 읽어온다.")
    @Test
    void test04() {
        assertThatThrownBy(() -> new Words(List.of("sister", "cake")))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("파일에서 알파벳으로만 이루어지지 않은 Words 를 읽어온다.")
    @Test
    void test05() {
        assertThatThrownBy(() -> new Words(List.of("12345", "a1234")))
                .isInstanceOf(IllegalStateException.class);
    }
}