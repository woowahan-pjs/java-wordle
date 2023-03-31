package wordle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    
    @Test
    void wordsToStringTest() {
        
        Words words = new Words("abcde");
        
        assertThat(words.castWordsToString()).isEqualTo("abcde");
    }
}
