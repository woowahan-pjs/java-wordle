package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordListReaderTest {

    @Test
    void 단어장이_존재한다면_특정_조건을_통해_정답을_추출할_수_있다() {
        WordListReader wordListReader = new WordListFileReader();
        WordList wordList = wordListReader.read();

        final Word actual = wordList.select(new TestSelector());
        assertEquals(new Answer("apple"), actual);
    }

    class TestSelector implements Selector {

        @Override
        public Word select(final List<Word> wordList) {
            return wordList.getFirst();
        }
    }
}
