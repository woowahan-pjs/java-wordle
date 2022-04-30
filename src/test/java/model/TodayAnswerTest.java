package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TodayAnswerTest {

    @DisplayName("오늘이 2021년 6월 29일이고 정답의 갯수가 3개면 1번째 단어가 정답이다.")
    @Test
    void choiceAnswer() {

        List<Characters> characters = List.of(
                new Characters("abcds"),
                new Characters("weqwr"),
                new Characters("eeiwq"));
        TodayAnswer todayAnswer = new TodayAnswer(characters);
        LocalDate today = LocalDate.of(2021, 6, 29);
        Characters result = todayAnswer.choiceAnswer(today);

        Results results = result.match(new Characters("weqwr"));
        assertThat(results.getResults()).containsExactly(Result.MATCH, Result.MATCH, Result.MATCH,
                Result.MATCH, Result.MATCH);
    }

}