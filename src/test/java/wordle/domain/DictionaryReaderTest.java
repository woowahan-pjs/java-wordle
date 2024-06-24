package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DictionaryReaderTest {

    @Test
    void 단어장이_존재한다면_특정_조건을_통해_정답을_추출할_수_있다() {
        final DictionaryReader dictionaryReader = new TestDictionaryReader();
        final Dictionary dictionary = dictionaryReader.read();

        assertNotNull(dictionary);
    }


    class TestDictionaryReader implements DictionaryReader {

        @Override
        public Dictionary read() {
            return new Dictionary(List.of(new DictionaryWord("apple")));
        }
    }
}
