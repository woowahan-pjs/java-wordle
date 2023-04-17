package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("단어 테스트")
class WordTest {

    @DisplayName("String 을 통해 단어를 생성한다.")
    @Test
    void createWordFromStringTest() {
        String input = "spill";
        assertThatCode(() -> Word.from(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("단어가 다섯글자가 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcdefgae", "abcabc"})
    void wordLengthTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Word.from(input));
    }

    @DisplayName("입력한 단어가 null 혹은 빈 값이면 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void wordWithNullAndEmptyTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Word.from(input));
    }

    @DisplayName("단어에 글자가 포함되어 었는지 여부 확인")
    @ParameterizedTest
    @ValueSource(chars = {'s', 'p', 'i', 'l', 'l'})
    void containsTest(char expected) {
        String input = "spill";
        Word word = Word.from(input);
        assertThat(word.contains(new Letter(expected))).isTrue();
    }
}
