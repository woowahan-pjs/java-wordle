package wordle.domain;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeBaseAnswerSelectorTest {

    @Test
    void 날짜_기반_단어_선택기는_주어진_날짜를_기준으로_단어를_선택할_수_있다() {
        // given
        final TimeBaseAnswerSelector answerSelector = new TimeBaseAnswerSelector(LocalDate.of(2024, 6, 9));
        final String expectedWord = "cigar";
        final List<Word> words = List.of(expectedWord, "apple", "grape", "melon").stream()
                .map(Word::new)
                .toList();

        // when
        final Word actual = answerSelector.select(words);

        // then
        assertEquals(actual, new Word(expectedWord));
    }
}
