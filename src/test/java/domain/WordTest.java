package domain;

import org.assertj.core.api.Assertions;
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
}
