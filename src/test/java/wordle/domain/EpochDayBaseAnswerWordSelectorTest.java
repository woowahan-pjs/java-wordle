package wordle.domain;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EpochDayBaseAnswerWordSelectorTest {

    @Test
    void 날짜_기반_단어_선택기는_주어진_날짜를_기준으로_단어를_선택할_수_있다() {
        // given
        final EpochDayBaseAnswerSelector answerSelector = new EpochDayBaseAnswerSelector(LocalDate.of(2024, 6, 9));
        final String expectedWord = "grape";
        final List<Word> wordList = Stream.of("cigar", "apple", expectedWord, "melon")
                .map(Word::new)
                .toList();

        // when
        final Word actual = answerSelector.select(wordList);

        // then
        assertEquals(actual, new Word(expectedWord));
    }
}
