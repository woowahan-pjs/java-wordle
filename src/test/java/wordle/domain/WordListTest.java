package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordListTest {


    @Test
    void Selector가_주어진다면_조건에_해당하는_단어를_추출할_수_있다() {
        Word word = new Word("cigar");

        WordList wordList = new WordList(List.of(word));
        Word actual = wordList.select((it) -> it.get(0));

        assertEquals(actual, word);
    }

    @Test
    void Selector가_주어졌지만_조건에_해당하는_단어가_없다면_예외를_발생한다() {
        WordList wordList = new WordList(List.of());

        assertThrows(RuntimeException.class, () -> wordList.select((it) -> it.get(0)));
    }
}
