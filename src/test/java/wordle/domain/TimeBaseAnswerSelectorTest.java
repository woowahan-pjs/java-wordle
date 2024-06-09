package wordle.domain;


import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeBaseAnswerSelectorTest {

    @Test
    void 날짜_기반_단어_선택기는_주어진_날짜를_기준으로_단어를_선택할_수_있다() {
        // given
        final TimeBaseAnswerSelector answerSelector = new TimeBaseAnswerSelector(ZonedDateTime.now(ZoneId.of("Asis/Seoul")));
        final List<Word> words = List.of("cigar", "circle", "apple", "banana", "orange", "grape", "melon").stream()
                .map(Word::new)
                .toList();

        // when
        final Word select = answerSelector.select(words);

        // then
        assertEquals(select, new Word("circle"));
    }
}
