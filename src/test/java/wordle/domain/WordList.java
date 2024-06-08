package wordle.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordListTest {

    @Test
    public void 주어진_단어가_wordList_안에_있으면_true를_반환한다() {
        // given
        Word word = new Word("cigar");
        WordList wordList = new WordList();

        // when
        boolean actual = wordList.contains(word);

        // then
        assertTrue(actual);
    }
}
