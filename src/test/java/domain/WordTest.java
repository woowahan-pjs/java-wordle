package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WordTest {

    @DisplayName("Word 를 생성한다.")
    @Test
    void test01() {
        Word word = new Word("SLiPP");

        assertThat(word.getWord()).isEqualTo("SLiPP");
    }

    @DisplayName("Word 가 5글자가 아니면 에러를 발생한다.")
    @Test
    void test02() {
        assertThatThrownBy(() -> new Word("Real"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Word 가 알파벳이 아니면 에러를 발생한다.")
    @Test
    void test03() {
        assertThatThrownBy(() -> new Word("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}