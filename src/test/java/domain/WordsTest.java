package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
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

    @DisplayName("words 정답을 가져온다.")
    @ParameterizedTest
    @MethodSource("generateAnswerData")
    void test04(LocalDate now, String result) {
        Words words = new Words(List.of("MySQL", "SLiPP", "Words"));

        Answer answer = words.getAnswer(now);

        assertThat(answer).isEqualTo(getAnswer(result));
    }

    @DisplayName("Word 를 가져온다.")
    @Test
    void test05() {
        Words words = new Words(List.of("MySQL", "SLiPP", "Words"));

        Word word = words.getWord("MySQL");

        assertThat(word).isEqualTo(new Word("MySQL"));
    }

    @DisplayName("Word 가 존재하지 않는다면 에러가 발생한다.")
    @Test
    void test06() {
        Words words = new Words(List.of("MySQL", "SLiPP", "Words"));

        assertThatThrownBy(() -> words.getWord("build"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateAnswerData() {
        return Stream.of(
                Arguments.of(Words.DEFAULT_DATE.plusDays(0), "MySQL"),
                Arguments.of(Words.DEFAULT_DATE.plusDays(1), "SLiPP"),
                Arguments.of(Words.DEFAULT_DATE.plusDays(2), "Words"),
                Arguments.of(Words.DEFAULT_DATE.plusDays(3), "MySQL"),
                Arguments.of(Words.DEFAULT_DATE.plusDays(4), "SLiPP")
        );
    }

    private static Answer getAnswer(String result) {
        return new Answer(new Word(result));
    }
}