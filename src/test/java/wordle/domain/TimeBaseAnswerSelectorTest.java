package wordle.domain;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeBaseAnswerSelectorTest {

    @Test
    void 날짜_기반_단어_선택기는_주어진_날짜를_기준으로_단어를_선택할_수_있다() {
        // given
        final TimeBaseAnswerSelector answerSelector = new TimeBaseAnswerSelector(LocalDate.of(2024, 6, 9));
        final String expectedWord = "cigar";
        final WordList wordList = new WordList(expectedWord, "apple", "grape", "melon");

        // when
        final Word actual = answerSelector.select(wordList);

        // then
        assertEquals(actual, new Word(expectedWord));
    }
}
