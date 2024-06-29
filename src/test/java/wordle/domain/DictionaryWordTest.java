package wordle.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryWordTest {

    @ValueSource(strings = {
            "", "a", "ab", "abc", "abcd", "abcdef",
            "ㄱabcde", "!@$fz", "24315", "a1b2c", "a1b2c$",
            "abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE",
    })
    @ParameterizedTest(name = "단어장 단어는 모든 문자열 중 하나인 {0} 에 대해서 생성 할 수 있다")
    void 단어장_단어는_모든_문자열에_대해서_생성_할_수_있다(final String word) {
        assertDoesNotThrow(() -> new DictionaryWord((word)));
    }

    @ValueSource(strings = {
            "", "a", "ab", "abc", "abcd", "abcdef",
            "ㄱabcde", "!@$fz", "24315", "a1b2c", "a1b2c$",
            "abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE",
    })
    @ParameterizedTest(name = "단어장 단어는 생성될 때 사용한 문자열 {0} 에 대해서 반환 할 수 있다")
    void 단어장_단어는_생성될_때_사용한_문자열을_반환_할_수_있다(final String expected) {
        final DictionaryWord dictionaryWord = new DictionaryWord((expected));

        assertEquals(expected, dictionaryWord.word());
    }
}
