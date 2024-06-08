package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordListTest {


    @Test
    void 주어진_단어가_wordList_안에_있으면_true를_반환한다() {
        // given
        Word word = new Word("cigar");
        WordList wordList = new WordList(List.of(new Word("cigar")));

        // when
        boolean actual = wordList.contains(word);

        // then
        assertTrue(actual);
    }

    @Test
    void 주어진_단어가_wordList_안에_없으면_false를_반환한다() {
        // given
        Word word = new Word("ooooo");
        WordList wordList = new WordList(new ArrayList<>());

        // when
        boolean actual = wordList.contains(word);

        // then
        assertFalse(actual);
    }

    @Test
    void Selector가_주어진다면_조건에_해당하는_단어를_추출할_수_있다() {
        Word word = new Word("cigar");

        WordList wordList = new WordList(List.of(word));
        Word actual = wordList.select(() -> word);

        assertEquals(actual, word);
    }
}
