package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordTest {

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"a:true", "b:true", "f:false", "g:false"})
    void 문자_포함여부_확인(char character, boolean contain) {
        //given
        Word word = new Word("abcde");

        //when
        Assertions.assertThat(word.isContains(character)).isEqualTo(contain);
    }

    @Test
    void compare() {
        //given
        Word answer = new Word("spill");

        //when
        Colors colors = answer.compareWith(new Word("hello"));

        //then
        Assertions.assertThat(colors).isEqualTo(
            new Colors(Color.GREY, Color.GREY, Color.YELLOW, Color.GREEN, Color.GREY)
        );
    }
    
    @Test
    void sizeCheck() {
        Assertions.assertThatThrownBy(() -> new Words("aaaa"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("단어는 다섯글자로만 입력 가능합니다");
    }
}
