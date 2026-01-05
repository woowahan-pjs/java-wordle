package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordListReaderTest {

    @Test
    void 단어장이_존재한다면_특정_조건을_통해_정답을_추출할_수_있다() {
        final WordListReader wordListReader = new TestWordListReader();
        final WordList wordList = wordListReader.read();

        final Word actual = wordList.select((it) -> it.get(0));
        assertEquals(new Word("apple"), actual);
    }


    class TestWordListReader implements WordListReader {

        @Override
        public WordList read() {
            return new WordList(List.of(new Word("apple")));
        }
    }
}
