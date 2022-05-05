package domain;

import mock.WordsMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WordsTest {

    @Test
    @DisplayName("오늘의 단어는 hello이다")
    void todayWordTest() {
        Words words = new WordsMock();
        Letters todayWords = words.getTodayWords();

        assertThat(todayWords).isEqualTo(Letters.of("hello"));
    }

    @Test
    @DisplayName("단어가 포함되면 true 이다")
    void containsTest() {
        Words words = new WordsMock();

        assertThat(words.contains(Letters.of("hello"))).isTrue();
    }

    @Test
    @DisplayName("단어가 포함되지 않으면 false 이다")
    void notContainsTest() {
        Words words = new WordsMock();

        assertThat(words.contains(Letters.of("aaaaa"))).isFalse();
    }

    @Test
    @DisplayName("단어가 포함되지 않으면 예외를 던진다")
    void isNotContainsTest() {
        Words words = new WordsMock();

        assertThatIllegalArgumentException().isThrownBy(() -> words.isContains(Letters.of("aaaaa")));
    }
}
