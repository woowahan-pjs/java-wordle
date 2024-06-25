package wordle.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryReaderTest {

    @ValueSource(strings = {"apple", "banana", "cherry"})
    @ParameterizedTest(name = "단어장을 만들 때 사용한 문자열 {0} 을 읽을 수 있다")
    void 단어장이_존재한다면_특정_조건을_통해_정답을_추출할_수_있다(final String word) {
        final List<DictionaryWord> dictionaryWords = List.of(new DictionaryWord(word));
        final Dictionary expected = new Dictionary(dictionaryWords);

        final DictionaryReader dictionaryReader = new TestDictionaryReader(dictionaryWords);
        assertEquals(expected, dictionaryReader.read());
    }


    class TestDictionaryReader implements DictionaryReader {
        private final List<DictionaryWord> words;

        public TestDictionaryReader(final List<DictionaryWord> words) {
            this.words = words;
        }

        @Override
        public Dictionary read() {
            return new Dictionary(words);
        }
    }
}
