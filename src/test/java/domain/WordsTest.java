package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WordsTest {

    @DisplayName("Word 를 생성한다.")
    @Test
    void test01() {
        Words words = new Words(List.of("MySQL", "SLiPP"));

        assertThat(words.getMatchWords()).containsExactly("MySQL", "SLiPP");
    }

    @DisplayName("문자와 숫자가 섞인 파일에서 Words 를 읽어온다.")
    @Test
    void test02() {
        Words words = new Words(List.of("MySQL", "cake", "12345"));

        assertThat(words.getMatchWords()).containsExactly("MySQL");
    }

    @DisplayName("주어진 Words 가 비어있으면 에러가 발생한다.")
    @Test
    void test03() {
        assertThatThrownBy(() -> new Words(Collections.emptyList())).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("주어진 Words 에 Word 가 없다면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void test04(List<String> words) {
        assertThatThrownBy(() -> new Words(words)).isInstanceOf(IllegalStateException.class);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of("sister", "cake")),
                Arguments.of(List.of("12345", "a1234")));
    }
}