package wordle.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {


    @Test
    void Selector가_주어진다면_조건에_해당하는_단어를_추출할_수_있다() {
        final DictionaryWord word = new DictionaryWord("cigar");

        final Dictionary dictionary = new Dictionary(List.of(word));
        final Answer answer = dictionary.answer((it) -> it.get(0));

        assertNotNull(answer);
    }

    @Test
    void Selector가_주어졌지만_조건에_해당하는_단어가_없다면_예외를_발생한다() {
        final Dictionary dictionary = new Dictionary(List.of());

        assertThrows(RuntimeException.class, () -> dictionary.answer((it) -> it.get(0)));
    }
}
