package domain;

import domain.Word;
import domain.Words;
import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordsTest {

    @ParameterizedTest
    @CsvSource(value = {
        "2021-06-19:aaaaa",
        "2021-06-20:bbbbb",
        "2021-06-21:ccccc",
        "2021-06-22:aaaaa",
        "2021-06-23:bbbbb",
        "2021-06-24:ccccc",
    }, delimiter = ':')
    void 날짜_단위로_정답_선정(LocalDate to, Word input) {
        //given
        Words words = new Words("aaaaa", "bbbbb", "ccccc");
        LocalDate from = LocalDate.of(2021, 6, 19);

        //when
        Word answer = words.answer(from, to);

        //then
        Assertions.assertThat(answer).isEqualTo(input);
    }

    @Test
    void 존재하지_않는_단어_조회시_에러발생() {
        //given
        Words words = new Words("aaaaa");

        //when & then
        Assertions.assertThatThrownBy(() -> words.getWord("bbbbb"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("단어집에 없는 단어를 선택하였습니다.");
    }
}
