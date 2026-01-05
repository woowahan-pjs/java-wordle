package wordle.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DictionaryTest {

    @ValueSource(strings = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "zxcvb", "ABCDE", "AbcdE"})
    @ParameterizedTest(name = "단어장을 만들 때 사용한 문자열 {0} 을 읽을 수 있다")
    void 단어장에_존재하는_단어는_추춣할_수_있다(final String word) {
        final DictionaryWord dictionaryWord = new DictionaryWord(word);
        final Dictionary dictionary = new Dictionary(List.of(dictionaryWord));
        final Word actual = dictionary.select((it) -> dictionaryWord);

        assertNotNull(actual);
    }
}
