package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
        Word actual = wordList.select(List::getFirst);

        assertEquals(actual, word);
    }

    @Test
    void Selector가_주어졌지만_조건에_해당하는_단어가_없다면_얘외를_발생한다() {
        WordList wordList = new WordList(List.of());

        assertThrows(NoSuchElementException.class, () -> wordList.select(List::getFirst));
    }

    @Test
    void 주어진_단어가_5글자가_아니라면_예외를_발생한다() {
        // given when then
        assertThrowsExactly(RuntimeException.class, () -> new Word("abcdef"));
    }
}
