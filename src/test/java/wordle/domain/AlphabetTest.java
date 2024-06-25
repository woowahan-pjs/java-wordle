package wordle.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class AlphabetTest {

    @ValueSource(chars = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    })
    @ParameterizedTest(name = "영단어 {0} 로 Alphabet 객체를 생성할 수 있다")
    void 영단어로_Alphabet_객체를_생성할_수_있다(char alphabet) {
        assertDoesNotThrow(() -> Alphabet.of(alphabet));
    }

    @ValueSource(chars = {
            'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')'
    })
    @ParameterizedTest(name = "영단어가 아닌 {0} 로 Alphabet 객체를 생성할 수 없다")
    void 영단어가_아닌_단어가_들어온다면_Alphabet을_생성할_수_없다(char alphabet) {
        assertThrowsExactly(IllegalArgumentException.class, () -> Alphabet.of(alphabet));
    }
}
