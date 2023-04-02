package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("글자 VO 테스트")
class LetterTest {

    @DisplayName("글자 생성 테스트")
    @Test
    void createLetterTest() {
        assertThatCode(() -> new Letter('a', 0))
                .doesNotThrowAnyException();
    }

    @DisplayName("글자가 영어가 아니면 IllegalArgumentException 발생 테스트")
    @Test
    void throwIllegalArgumentExceptionWhenNotEnglishTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Letter('å', 1));
    }

    @DisplayName("같은 문자면 같은 객체인지 테스트")
    @Test
    void equalsValueTest() {
        Letter a = new Letter('a', 1);
        Letter aLetter = new Letter('a', 2);
        assertThat(a).isEqualTo(aLetter);
    }

}
