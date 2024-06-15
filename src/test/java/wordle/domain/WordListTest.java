package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordListTest {


    @Test
    void Selector가_주어진다면_조건에_해당하는_단어를_추출할_수_있다() {
        DictionaryWord word = new DictionaryWord("cigar");

        WordList wordList = new WordList(List.of(word));
        GameWord actual = wordList.select((it) -> new GameWord(it.get(0)));

        assertEquals(actual, word);
    }

    @Test
    void Selector가_주어졌지만_조건에_해당하는_단어가_없다면_예외를_발생한다() {
        WordList wordList = new WordList(List.of());

        assertThrows(RuntimeException.class, () -> wordList.select((it) -> new GameWord(it.get(0))));
    }
}
