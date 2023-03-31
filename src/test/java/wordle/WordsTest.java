package wordle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WordsTest {

    @Test
    @DisplayName("Words의 길이는 5를 초과한 경우 실패합니다.")
    void wordsLegnthShouldEqualTo5() {
        assertThatThrownBy(() -> new Words("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Words의 길이는 5 미만인 경우 실패합니다.")
    void wordsLengthLessThan5ShouldFail() {
        assertThatThrownBy(() -> new Words("abcd")).isInstanceOf(IllegalArgumentException.class);
    }
}
