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

        assertThat(words.getWords()).containsExactly(new Word("MySQL"), new Word("SLiPP"));
    }

    @DisplayName("주어진 Words 가 비어있으면 에러가 발생한다.")
    @Test
    void test02() {
        assertThatThrownBy(() -> new Words(Collections.emptyList())).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 Words 에 Word 가 없다면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void test03(List<String> words) {
        assertThatThrownBy(() -> new Words(words)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of("MySQL", "cake", "12345")),
                Arguments.of(List.of("sister", "cake")),
                Arguments.of(List.of("12345", "a1234")));
    }
}